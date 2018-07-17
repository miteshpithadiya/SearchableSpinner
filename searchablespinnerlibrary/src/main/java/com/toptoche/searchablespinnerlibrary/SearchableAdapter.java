package com.toptoche.searchablespinnerlibrary;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

public class SearchableAdapter extends ArrayAdapter<String> implements Filterable {

    private ArrayList<String> items;
    private ArrayList<String> filteredItems;

    SearchableAdapter(Context context, int resource, ArrayList<String> objects) {
        super(context, resource, objects);
        this.items = objects;
        this.filteredItems = objects;
    }

    @Override
    public int getCount() {
        return filteredItems.size();
    }

    @Override
    public String getItem(int position) {
        return filteredItems.get(position);
    }

    private List<String> getAllItems() {
        return items;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                ArrayList<String> filteredItems = new ArrayList<>();
                List<String> items = getAllItems();

                if (constraint == null || constraint.length() == 0) {
                    results.values = items;
                    results.count = items.size();
                } else {
                    for (String item : items) {
                        if (item.toLowerCase().contains(constraint.toString().toLowerCase())) {
                            filteredItems.add(item);
                        }
                    }
                    results.values = filteredItems;
                    results.count = filteredItems.size();
                }

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredItems = (ArrayList<String>) results.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }
}
