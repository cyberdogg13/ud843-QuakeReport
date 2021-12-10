package com.example.android.quakereport;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;

import java.text.DecimalFormat;
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
        Double Mag = Double.valueOf(String.valueOf(currentEartQuake.getMagintude()));
        //create a formatter for changing the magnitude values to single decimal if needed
        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(Mag);
        // fill that view with the magnitude of the current earthquake
        magnitudeView.setText(output);
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();


        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(Double.valueOf(currentEartQuake.getMagintude()));

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        // find the textview with de view id date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        //fill the textview with de date of the current earthquake
        dateView.setText((currentEartQuake.getdate()));


        // split current location at the firts occurance of "of"
        try {
            String parts[] = currentEartQuake.getlocation().split("(?<=of)");

            // find the view with the view id location
            TextView locationView = (TextView) listItemView.findViewById(R.id.location);
            locationView.setText(parts[1]);
            TextView locationoffsetView = (TextView) listItemView.findViewById(R.id.locatinOffset);
            locationoffsetView.setText(parts[0]);

            // on fail just fill the location view with the whole location string
            // and remove last locationOffset input string
        } catch (Exception e) {
            System.out.println("error");
            TextView locationView = (TextView) listItemView.findViewById(R.id.location);
            locationView.setText(currentEartQuake.getlocation());
            TextView locationoffsetView = (TextView) listItemView.findViewById(R.id.locatinOffset);
            locationoffsetView.setText(" ");
        }


        return listItemView;
    }

    int magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude1);
    int magnitude2Color = ContextCompat.getColor(getContext(), R.color.magnitude2);
    int magnitude3Color = ContextCompat.getColor(getContext(), R.color.magnitude3);
    int magnitude4Color = ContextCompat.getColor(getContext(), R.color.magnitude4);
    int magnitude5Color = ContextCompat.getColor(getContext(), R.color.magnitude5);
    int magnitude6Color = ContextCompat.getColor(getContext(), R.color.magnitude6);
    int magnitude7Color = ContextCompat.getColor(getContext(), R.color.magnitude7);
    int magnitude8Color = ContextCompat.getColor(getContext(), R.color.magnitude8);
    int magnitude9Color = ContextCompat.getColor(getContext(), R.color.magnitude9);
    int magnitude10Color = ContextCompat.getColor(getContext(), R.color.magnitude10plus);

    public int getMagnitudeColor(double magnitude) {
        int result = 0;
        int value = (int) magnitude;
        switch (value) {
            case 0:
                result = magnitude1Color;
                break;
            case 1: {
                result = magnitude2Color;
                break;
            }
            case 2: {
                result = magnitude3Color;
                break;
            }
            case 3: {
                result = magnitude4Color;
                break;
            }
            case 4: {
                result = magnitude5Color;
                break;
            }
            case 5: {
                result = magnitude6Color;
                break;
            }
            case 6: {
                result = magnitude7Color;
                break;
            }
            case 7: {
                result = magnitude8Color;
                break;
            }
            case 8: {
                result = magnitude9Color;
                break;
            }
            case 9: {
                result = magnitude10Color;
                break;
            }
            default: {
                result = magnitude10Color;
                break;
            }

        }
        return result;
    }
}
