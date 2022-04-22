package com.example.gamma_restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ReviewsOptions extends AppCompatActivity {

    Button rate_restaurant_button, see_reviews_button;
    ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviews_options);

        // Get all buttons by their IDs
        rate_restaurant_button = (Button) findViewById(R.id.RateRestaurantButton); // Rate restaurant button
        see_reviews_button = (Button) findViewById(R.id.SeeReviewsButton); // See Reviews button
        home = (ImageButton) findViewById(R.id.home); // Home button

        // When the "Rate Restaurant" button is pressed open an activity to get user's name info
        rate_restaurant_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openRateRestaurant();
            }
        });

        // When the "See Reviews" button is pressed open the "Reviews Display" page
        see_reviews_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openReviewsDisplay();
            }
        });

        // When the "home" button is pressed go to home page
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openHomePage();
            }
        });

    }

    // Rate Restaurant Activity Method
    public void openRateRestaurant(){
        Intent intent = new Intent(this, RateRestaurant.class);
        startActivity(intent);
    }

    // Rate Restaurant Activity Method
    public void openReviewsDisplay(){
        Intent intent = new Intent(this, ReviewsDisplay.class);
        startActivity(intent);
    }

    // Home Activity Method
    public void openHomePage(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
