package com.toptoche.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.toptoche.searchablespinnerlibrary.SearchableListDialog;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

public class MainActivity extends AppCompatActivity {

    private SearchableSpinner searchableSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchableSpinner = (SearchableSpinner) findViewById(R.id.spinner);

        searchableSpinner.setOnSearchTextChangedListener(new SearchableListDialog.OnSearchTextChanged() {
            @Override
            public void onSearchTextChanged(String strText) {
                Log.d("Text Changed", strText);
            }
        });
    }
}
