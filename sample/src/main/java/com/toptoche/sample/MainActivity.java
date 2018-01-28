package com.toptoche.sample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.toptoche.searchablespinnerlibrary.OnSearchTextChanged;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener, OnSearchTextChanged {

    private SearchableSpinner searchableSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchableSpinner = (SearchableSpinner) findViewById(R.id.searchableSpinner);

        searchableSpinner.setHint(getString(R.string.you_know_nothing));
        searchableSpinner.setTitle(getString(R.string.select_a_person));
        searchableSpinner.setPositiveButton(getString(android.R.string.ok), this);
        searchableSpinner.setOnSearchTextChangedListener(this);

        searchableSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.starks)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItem:
                searchableSpinner.searchableItemClick(3); // JON SNOW POSITION!
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int position) {
        Toast.makeText(this, getString(android.R.string.ok), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSearchTextChanged(String newText) {
        Toast.makeText(this, String.format(getString(R.string.search_string_changed_to_x), newText), Toast.LENGTH_SHORT).show();
    }
}
