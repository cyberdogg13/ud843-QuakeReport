package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    public View getView(int position, View convertview, ViewGroup parent) {

        View listItemView = convertview;
        if (listItemView == null) {
         listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }

        // find the earthquake at the given position in the list of earthquakes
        Earthquake currentEartQuake = getItem(position);

        // find the textview with the view id magintude
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        // fill that view with the magnitude of the current earthquake
        magnitudeView.setText(currentEartQuake.getMagintude());

        // find the textview with de view id date
        TextView dateView = (TextView)  listItemView.findViewById(R.id.date);
        //fill the textview with de date of the current earthquake
        dateView.setText((currentEartQuake.getdate()));

        // find the vie with the view id location
        TextView locationView = (TextView)  listItemView.findViewById(R.id.location);
        locationView.setText(currentEartQuake.getlocation());

        return listItemView;
    }
}
