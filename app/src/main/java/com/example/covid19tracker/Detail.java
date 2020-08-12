package com.example.covid19tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    private int positionCountry;
    TextView tvcountry,tvcases,tvtodayCase,tvdeaths,tvtodayDeaths,tvrecovered,tvactive,tvcritical,tvtests;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        positionCountry = intent.getIntExtra("position",0);

        getSupportActionBar().setTitle("Detail of"+AffectedCountries.countrymodalList.get(positionCountry).getCountry());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        tvcountry = findViewById(R.id.tvcountry);
        tvcases = findViewById(R.id.tvcases);
        tvtodayCase= findViewById(R.id.tvtodayCase);
        tvdeaths = findViewById(R.id.tvdeaths);
        tvtodayDeaths = findViewById(R.id.tvtodayDeaths);
        tvrecovered = findViewById(R.id.tvrecovered);
        tvactive = findViewById(R.id.tvactive);
        tvcritical = findViewById(R.id.tvcritical);
        tvtests = findViewById(R.id.tvtests);

        tvcountry.setText(AffectedCountries.countrymodalList.get(positionCountry).getCountry());
        tvcases.setText(AffectedCountries.countrymodalList.get(positionCountry).getCases());
        tvtodayCase.setText(AffectedCountries.countrymodalList.get(positionCountry).getTodayCase());
        tvdeaths.setText(AffectedCountries.countrymodalList.get(positionCountry).getDeaths());
        tvtodayDeaths.setText(AffectedCountries.countrymodalList.get(positionCountry).getTodayDeaths());
        tvrecovered.setText(AffectedCountries.countrymodalList.get(positionCountry).getRecovered());
        tvactive.setText(AffectedCountries.countrymodalList.get(positionCountry).getActive());
        tvcritical.setText(AffectedCountries.countrymodalList.get(positionCountry).getCritical());
        tvtests.setText(AffectedCountries.countrymodalList.get(positionCountry).getTests());

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}