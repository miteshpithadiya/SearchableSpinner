package com.toptoche.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SearchableSpinner countrySpinner, stateSpinner, citySpinner;
    List<String> countryList = new ArrayList<>();
    List<String> stateList = new ArrayList<>();
    List<String> cityList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countrySpinner = (SearchableSpinner) findViewById(R.id.spinnerCountry);
        stateSpinner = (SearchableSpinner) findViewById(R.id.spinnerState);
        citySpinner = (SearchableSpinner) findViewById(R.id.spinnerCity);

        //Countries
        countryList.add("India");
        countryList.add("USA");
        countryList.add("UK");
        countryList.add("Brazil");
        countryList.add("Russia");
        //States
        stateList.add("Gujarat");
        stateList.add("Punjab");
        stateList.add("Goa");

        //Cities
        cityList.add("Ahmedabad");
        cityList.add("Delhi");
        cityList.add("Bombay");

        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, countryList);
        countrySpinner.setAdapter(countryAdapter);

        final ArrayAdapter<String> stateAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, stateList);
        stateSpinner.setAdapter(stateAdapter);

        final ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, cityList);
        citySpinner.setAdapter(cityAdapter);

        //Implementing method for Reset Spinner
        //If user Select Country again then State and City Spinner should be Reset

        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                stateSpinner.resetAdapter(stateAdapter);
                citySpinner.resetAdapter(cityAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                citySpinner.resetAdapter(cityAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
