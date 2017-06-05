package com.hetic.antoinegourtay.canieat.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hetic.antoinegourtay.canieat.R;

import butterknife.BindView;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.tofaqbutton)
    private Button faqButton;
    @BindView(R.id.tomapsbutton)
    private Button mapButton;
    @BindView(R.id.toaboutbutton)
    private Button aboutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        faqButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, FAQActivity.class);
                startActivity(i);
            }
        });

        mapButton.setOnClickListener(new View.OnClickListener() {
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
    }
}
