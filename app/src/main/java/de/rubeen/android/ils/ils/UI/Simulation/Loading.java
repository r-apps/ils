package de.rubeen.android.ils.ils.UI.Simulation;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import de.rubeen.android.ils.ils.R;
import de.rubeen.ils.Simulation;
import de.rubeen.ils.SimulationParams;

/**
 * Created by rubeen on 05.06.17.
 * loadingView with simulation initialization
 */

public class Loading extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation_loading);

        //implementation as backgroundTask
        new LoadFiles().execute(0);
    }

    /**
     * asynchronously initialize the main simulation object
     */
    //TODO Background task implementation
    private class LoadFiles extends AsyncTask<Integer, Integer, Integer> {

        /**
         * creates the object, may take some time
         *
         * @param params nothing
         * @return nothing
         */
        @Override
        protected Integer doInBackground(Integer... params) {
            new Simulation(new SimulationParams());
            //TODO: exception handling
            return 0;
        }

        /**
         * finish activity & create an intent
         * @param aInteger nothing
         */
        @Override
        protected void onPostExecute(Integer aInteger) {
            super.onPostExecute(aInteger);
            startActivity(new Intent(Loading.this, Home.class));
            finish();
        }
    }
}
