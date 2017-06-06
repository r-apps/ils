package de.rubeen.android.ils.ils.UI.Simulation;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import de.rubeen.android.ils.ils.R;

/**
 * Created by rubeen on 06.06.17.
 */

public class Dialer extends AppCompatActivity {
    private int i = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation_dialer);

        //Initialisation
        setupEditText();
        setupDialerButtons();
    }

    private void setupDialerButtons() {
        Button[] buttons = {
                (Button) findViewById(R.id.simulation_dialer_dialerContent_btn_1),
                (Button) findViewById(R.id.simulation_dialer_dialerContent_btn_2),
                (Button) findViewById(R.id.simulation_dialer_dialerContent_btn_3),
                (Button) findViewById(R.id.simulation_dialer_dialerContent_btn_4),
                (Button) findViewById(R.id.simulation_dialer_dialerContent_btn_5),
                (Button) findViewById(R.id.simulation_dialer_dialerContent_btn_6),
                (Button) findViewById(R.id.simulation_dialer_dialerContent_btn_7),
                (Button) findViewById(R.id.simulation_dialer_dialerContent_btn_8),
                (Button) findViewById(R.id.simulation_dialer_dialerContent_btn_9),
                (Button) findViewById(R.id.simulation_dialer_dialerContent_btn_STAR),
                (Button) findViewById(R.id.simulation_dialer_dialerContent_btn_0),
                (Button) findViewById(R.id.simulation_dialer_dialerContent_btn_HASH)
        };
        for (Button b : buttons) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((EditText) findViewById(R.id.simulation_dialer_editText)).append(((Button) v).getText());
                }
            });
        }

        findViewById(R.id.simulation_dialer_dialerContent_btn_BACK).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                new BackPressHandler().execute(event);
                return false;
            }
        });
    }

    private void setupEditText() {
        EditText editText = (EditText) findViewById(R.id.simulation_dialer_editText);
        ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        editText.setInputType(InputType.TYPE_NULL);
    }

    private class BackPressHandler extends AsyncTask<MotionEvent, Integer, Integer> {
        MotionEvent event = null;

        @Override
        protected void onPreExecute() {
            if (i != 0) {
                cancel(true);
                return;
            }
            super.onPreExecute();
        }

        @Override
        protected Integer doInBackground(MotionEvent... params) {
            try {
                do {
                    event = params[0];
                    publishProgress(0);
                    i++;
                    System.out.println(i);
                    Thread.sleep(100);
                }
                while (event.getAction() != MotionEvent.ACTION_UP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onProgressUpdate(Integer... values) {
            EditText text = (EditText) findViewById(R.id.simulation_dialer_editText);
            String s = text.getText().toString();
            if (s.length() > 0) {
                text.setText(new StringBuilder(s).deleteCharAt(s.length() - 1));
                if (i == 7)
                    text.setText("");
            }
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            if (event != null && event.getAction() == MotionEvent.ACTION_UP)
                i = 0;
            super.onPostExecute(integer);
        }
    }
}
