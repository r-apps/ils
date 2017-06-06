package de.rubeen.android.ils.ils.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import de.rubeen.android.ils.ils.R;
import de.rubeen.android.ils.ils.UI.Simulation.Loading;

/**
 * created by Rubeen
 * <p>
 * mainView aka. mainMenu
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupButtons();
    }

    /**
     * initializations for all menuButtons, this class as handler for less code
     */
    private void setupButtons() {
        Button[] buttons = {(Button) findViewById(R.id.menu_btn_help),
                (Button) findViewById(R.id.menu_btn_manual),
                (Button) findViewById(R.id.menu_btn_settings),
                (Button) findViewById(R.id.menu_btn_start)};
        for (Button b : buttons)
            b.setOnClickListener(this);
    }

    /**
     * Handler for all menu buttons
     *
     * @param v button
     */
    @Override
    public void onClick(View v) {
        //TODO: Button handler
        switch (v.getId()) {
            case R.id.menu_btn_start:
                System.out.println("pressed start");
                startActivity(new Intent(MainActivity.this, Loading.class));
                break;
            case R.id.menu_btn_settings:
                System.out.println("pressed settings");
                break;
            case R.id.menu_btn_manual:
                System.out.println("pressed manual");
                break;
            case R.id.menu_btn_help:
                System.out.println("pressed help");
                break;
            default:
                System.err.println("button not found (should not be happen): ".concat(v.toString()));
        }
    }
}
