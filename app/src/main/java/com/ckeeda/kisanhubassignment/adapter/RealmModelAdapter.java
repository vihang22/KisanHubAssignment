package com.ckeeda.kisanhubassignment.adapter;

import android.view.View;
import android.view.ViewGroup;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;
import io.realm.RealmObject;


public class RealmModelAdapter<T extends RealmObject> extends RealmBaseAdapter<T> {


    public RealmModelAdapter(OrderedRealmCollection<T> data){
        super((OrderedRealmCollection<T>) data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return null;
    }

}