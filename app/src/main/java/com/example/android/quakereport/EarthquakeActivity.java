/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        ArrayList<Earthquake> earthquakes = Quaryutils.extractEarthquakes();

        // test lijst van aardbevingen
//        ArrayList<Earthquake> earthquakes = new ArrayList<>();
//        earthquakes.add(new Earthquake("2.5", "amsterdam", "21-02-2020"));
//        earthquakes.add(new Earthquake("4.6", "griekenland", "09-01-2021"));
//        earthquakes.add(new Earthquake("2.8", "turkije", "12-09-2021"));
//        earthquakes.add(new Earthquake("1.0", "new york", "16-01-2021"));
//        earthquakes.add(new Earthquake("6.5", "colifornia", "19-11-2021"));
//        earthquakes.add(new Earthquake("9.1", "groningen", "11-06-2020"));
//        earthquakes.add(new Earthquake("2.4", "dusseldorf", "20-02-2020"));
//        earthquakes.add(new Earthquake("2.0", "navada", "01-02-2020"));
//        earthquakes.add(new Earthquake("9.0", "brussel", "02-02-2021"));

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }
}
