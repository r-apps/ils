package de.rubeen.android.ils.ils.UI.Simulation;

import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import de.rubeen.android.ils.ils.R;
import de.rubeen.android.ils.ils.UI.Simulation.adapter.OverviewViewAdapter;
import de.rubeen.ils.Simulation;

/**
 * Created by rubeen on 05.06.17.
 */

public class Home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation_home);

        //Initialisations
        floatingButton();
        setActionBar();
        fillOperationsList();

        //TODO sort
    }

    private void fillOperationsList() {
        Simulation simulation = Simulation.getInstance();
        OverviewViewAdapter viewAdapter = new OverviewViewAdapter(this, simulation.getOperations());
        ListView listView = (ListView) findViewById(R.id.simulation_home_overviewLayout);
        listView.setAdapter(viewAdapter);
    }

    private void setActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.simulation_home_toolbar);
        setSupportActionBar(toolbar);
    }

    private void floatingButton() {
        FloatingActionButton button = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home.this, "!new emergency form should open now.", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(Home.this).inflate(R.menu.simulation_menu, menu);
        menu.getItem(0).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }


    //TODO: option selection
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.simulation_menu_phone:
                Toast.makeText(Home.this, "dialer should open now.", Toast.LENGTH_SHORT).show();
                break;
            default:
                if (Debug.isDebuggerConnected())
                    new UnsupportedOperationException("Funktion noch nicht implementiert.");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
