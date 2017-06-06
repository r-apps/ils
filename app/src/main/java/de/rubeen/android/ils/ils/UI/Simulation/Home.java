package de.rubeen.android.ils.ils.UI.Simulation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
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
    //Positions for TABS
    private final int TAB_POSITION_OVERVIEW = 0;
    private final int TAB_POSITION_OPERATION = 1;
    private final int TAB_POSITION_CARS = 2;
    private final int TAB_POSITION_STATIONS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation_home);

        //Initialisations
        floatingButton();
        setActionBar();
        fillOperationsList();
        tabList();


        findViewById(R.id.simulation_home_loadingContainer).setVisibility(View.GONE);
        findViewById(R.id.simulation_home_overviewContainer).setVisibility(View.VISIBLE);
    }

    private void tabList() {
        TabLayout layout = (TabLayout) findViewById(R.id.simulation_home_tabBar);
        layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case TAB_POSITION_OVERVIEW:
                        findViewById(R.id.simulation_home_overviewContainer).setVisibility(View.VISIBLE);
                        break;
                    case TAB_POSITION_OPERATION:
                        break;
                    case TAB_POSITION_CARS:
                        break;
                    case TAB_POSITION_STATIONS:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case TAB_POSITION_OVERVIEW:
                        findViewById(R.id.simulation_home_overviewContainer).setVisibility(View.GONE);
                        break;
                    case TAB_POSITION_OPERATION:
                        break;
                    case TAB_POSITION_CARS:
                        break;
                    case TAB_POSITION_STATIONS:
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void fillOperationsList() {
        Simulation simulation = Simulation.getInstance();
        OverviewViewAdapter viewAdapter = new OverviewViewAdapter(this, simulation.getOperations());
        ListView listView = (ListView) findViewById(R.id.simulation_home_overviewContainer);
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
                startActivity(new Intent(Home.this, Dialer.class));
                break;
            default:
                if (Debug.isDebuggerConnected())
                    new UnsupportedOperationException("Funktion noch nicht implementiert.");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
