package com.ckeeda.kisanhubassignment.adapter;

import com.ckeeda.kisanhubassignment.Model.WeatherData;

import io.realm.OrderedRealmCollection;


public class RealmWeatherAdapter extends RealmModelAdapter<WeatherData> {


    public RealmWeatherAdapter(OrderedRealmCollection<WeatherData> data){
        super(data);

    }
}

