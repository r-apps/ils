package de.rubeen.android.ils.ils.UI.Simulation.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import de.rubeen.android.ils.ils.R;
import de.rubeen.ils.Operation;

/**
 * Created by rubeen on 05.06.17.
 *
 * ViewAdapter to create overViewList in simulation_home
 */

public class OverviewViewAdapter extends ArrayAdapter<Operation> {
    private Operation operation;

    public OverviewViewAdapter(Context context, ArrayList<Operation> operations) {
        super(context, 0, operations);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NotNull ViewGroup parent) {
        Operation operation = getItem(position);
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_simulation_home_overview, parent, false);
        //TODO: fill TB (convertView.findView(...))
        ((TextView) convertView.findViewById(R.id.item_simulation_home_overview_title)).setText(operation.getTitle());
        ((ProgressBar) convertView.findViewById(R.id.item_simulation_home_overview_progress)).setMax((int) operation.getMaxProgress());
        ((ProgressBar) convertView.findViewById(R.id.item_simulation_home_overview_progress)).setProgress((int) operation.getProgress());
        //TODO: set workforce.count textView
        ((TextView) convertView.findViewById(R.id.item_simulation_home_overview_address)).setText(operation.getAddress().toString());
        return convertView;
    }
}
