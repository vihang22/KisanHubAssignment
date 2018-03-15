package com.ckeeda.kisanhubassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SpinnerActivity extends AppCompatActivity {

    private Spinner region_spinner;
    private Spinner weather_spinner;
    private Button mNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        region_spinner = (Spinner) findViewById(R.id.spinner_region);
        weather_spinner = (Spinner) findViewById(R.id.spinner_weather);
        mNext = (Button) findViewById(R.id.btn_next);
        ArrayList<String> regiondata = new ArrayList<>();
        regiondata.add("UK");
        regiondata.add("England");
        regiondata.add("Wales");
        regiondata.add("Scotland");
        ArrayList<String> weatherdata = new ArrayList<>();
        weatherdata.add("Max Temp");
        weatherdata.add("Min Temp");
        weatherdata.add("Mean Temp");
        weatherdata.add("Sunshine");
        weatherdata.add("Rainfall");

        final ArrayAdapter<String> region_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,regiondata);
        ArrayAdapter<String> weather_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,weatherdata);

        region_spinner.setAdapter(region_adapter);
        weather_spinner.setAdapter(weather_adapter);

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(),
                        region_spinner.getSelectedItem().toString() + " " +
                        weather_spinner.getSelectedItem().toString(),
                        Toast.LENGTH_LONG).show();

                movetoRecyclerActivity();
            }
        });
    }

    private void movetoRecyclerActivity(){

        Intent recycleractivity = new Intent(this,RecyclerActivity.class);
        recycleractivity.putExtra("region",region_spinner.getSelectedItem().toString());
        recycleractivity.putExtra("weather",weather_spinner.getSelectedItem().toString());
        startActivity(recycleractivity);

    }

}
