package com.toptoche.searchablespinnerlibrary;

import java.io.Serializable;

/**
 * Created by pedrofsn on 26/08/2016.
 */
public interface SearchableItem<T> extends Serializable {

    void onSearchableItemClicked(T item, int position);

}