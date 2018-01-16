package com.toptoche.sample;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

public class MainActivity extends AppCompatActivity {

    SearchableSpinner searchableSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchableSpinner = (SearchableSpinner) findViewById(R.id.spinner);

        Button clear = (Button) findViewById(R.id.button);
        Button open = (Button) findViewById(R.id.show_dialog);

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchableSpinner.openSearchableDialog();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchableSpinner.setNoItemSelected();
                ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.one));
                searchableSpinner.setAdapter(spinnerArrayAdapter);

            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        if(searchableSpinner.isDialogOpen()) {
            searchableSpinner.removeSearchableDialog();
        }
    }
}
