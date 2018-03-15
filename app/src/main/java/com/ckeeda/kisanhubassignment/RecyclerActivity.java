package com.ckeeda.kisanhubassignment;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ckeeda.kisanhubassignment.Model.WeatherData;
import com.ckeeda.kisanhubassignment.adapter.RealmWeatherAdapter;
import com.ckeeda.kisanhubassignment.adapter.WeatherAdapter;

import io.realm.Realm;
import io.realm.RealmResults;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView rv;
    private String region;
    private String weather;
    private Realm realm;
    private WeatherAdapter adapter;
    private Context context ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        context =  (Application) getApplicationContext();
        region = getIntent().getStringExtra("region");
        weather = getIntent().getStringExtra("weather");
        rv = (RecyclerView) findViewById(R.id.recycler);

        realm = RealmController.with(this).getRealm();
        setupRecycler();

        setRealmAdapter(new RealmController((Application) getApplicationContext()).queryeddata(region,weather));

   }

    private void setRealmAdapter(RealmResults<WeatherData> queryeddata) {

        RealmWeatherAdapter realmAdapter = new RealmWeatherAdapter(queryeddata);

        adapter.setRealmAdapter(realmAdapter);
        adapter.notifyDataSetChanged();
    }

    private void setupRecycler() {

        rv.setHasFixedSize(true);


        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(layoutManager);

        adapter = new WeatherAdapter(this);
        rv.setAdapter(adapter);
    }
}
