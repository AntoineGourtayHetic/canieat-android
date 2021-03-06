package com.hetic.antoinegourtay.canieat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import com.hetic.antoinegourtay.canieat.R;

public class HomeActivity extends AppCompatActivity {


    private Button carteButton;
    private Button aboutButton;
    private Button recipesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        carteButton = (Button) findViewById(R.id.tomapsbutton);
        aboutButton = (Button) findViewById(R.id.toaboutbutton);
        recipesButton = (Button) findViewById(R.id.torecipes);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;


        carteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, MapsActivity.class);
                startActivity(i);
            }
        });

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, AboutActivity.class);
                startActivity(i);
            }
        });

        recipesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this,ReceipesActivity.class);
                startActivity(i);
            }
        });

        carteButton.setWidth(width);
        carteButton.setHeight(height / 4);

        aboutButton.setWidth(width);
        aboutButton.setHeight(height / 4);

        recipesButton.setWidth(width);
        recipesButton.setHeight(height / 4);


    }
}
