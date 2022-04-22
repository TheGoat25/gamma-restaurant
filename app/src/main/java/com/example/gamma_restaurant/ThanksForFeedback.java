package com.example.gamma_restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ThanksForFeedback extends AppCompatActivity {

    ImageButton close;
    Button see_reviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.thanks_for_feedback);

        // Get the buttons by their IDs
        close = (ImageButton) findViewById(R.id.close);
        see_reviews = (Button) findViewById(R.id.SeeReviewsButton);

        // When the "close" button is pressed go to the home page
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openHome();
            }
        });

        // When the "See Reviews" button is pressed go to the See Reviews page
        see_reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openReviewsDisplay();
            }
        });
    }

    // Home Activity Method
    public void openHome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // See Reviews Activity Method
    public void openReviewsDisplay(){
        Intent intent = new Intent(this, ReviewsDisplay.class);
        startActivity(intent);
    }

}
