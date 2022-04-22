package com.example.gamma_restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnMenu, btnReviews, btnReservations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FoodMenuActivity.class);
                startActivity(intent);
            }
        });

        btnReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, ReviewsDisplay.class);
                startActivity(intent2);
            }
        });

        btnReservations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, ReservationsActivity.class);
                startActivity(intent3);
            }
        });

    }

    private void initViews() {

        btnMenu = findViewById(R.id.btnMenu);
        btnReviews = findViewById(R.id.btnReviews);
        btnReservations = findViewById(R.id.btnReservations);

    }
}