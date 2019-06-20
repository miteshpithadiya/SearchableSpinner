package com.toptoche.sample;

import android.os.Bundle;
import android.view.Gravity;

import androidx.appcompat.app.AppCompatActivity;

import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SearchableSpinner spinner = findViewById(R.id.spinner);
        spinner.setTitle("Some Title");
        spinner.setTitleGravity(Gravity.CENTER_HORIZONTAL);

    }
}
