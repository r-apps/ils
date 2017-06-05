package de.rubeen.android.ils.ils.UI.Simulation;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import de.rubeen.android.ils.ils.BuildConfig;
import de.rubeen.android.ils.ils.R;
import de.rubeen.ils.Simulation;
import de.rubeen.ils.SimulationParams;

/**
 * Created by rubeen on 05.06.17.
 */

public class Loading extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation_loading);

        new LoadFiles().execute(0);
    }

    //TODO Background task implementation
    private class LoadFiles extends AsyncTask<Integer, Integer, Integer> {
        @Override
        protected Integer doInBackground(Integer... params) {
            new Simulation(new SimulationParams(BuildConfig.DEBUG));
            return 0;
        }

        @Override
        protected void onPostExecute(Integer aInteger) {
            super.onPostExecute(aInteger);
            startActivity(new Intent(Loading.this, Home.class));
            finish();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }
}
