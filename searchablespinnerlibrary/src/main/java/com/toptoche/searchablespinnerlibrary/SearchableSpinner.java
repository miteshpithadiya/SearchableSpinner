package com.toptoche.searchablespinnerlibrary;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by miteshp on 8/28/2015.
 */
public class SearchableSpinner extends Spinner implements View.OnTouchListener,
        SearchableListDialog.SearchableItem {

    private Context _context;
    private List _items;

    public SearchableSpinner(Context context) {
        super(context);
        this._context = context;
        init();
    }

    public SearchableSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        this._context = context;
        init();
    }

    public SearchableSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this._context = context;
        init();
    }

    private void init() {
        _items = new ArrayList();
        setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            ArrayAdapter adapter = (ArrayAdapter) getAdapter();

            if (null != adapter) {

                if (_items.size() == 0) {
                    for (int i = 0; i < adapter.getCount(); i++) {
                        _items.add(adapter.getItem(i));
                    }
                }
                SearchableListDialog searchableListDialog = SearchableListDialog.newInstance
                        (_items);
                searchableListDialog.setOnSearchableItemClickListener(this);
                searchableListDialog.show(((Activity) _context).getFragmentManager(), "TAG");
            }
        }
        return true;
    }

    @Override
    public void onSearchableItemClicked(Object item, int position) {
        setSelection(_items.indexOf(item));
    }
}