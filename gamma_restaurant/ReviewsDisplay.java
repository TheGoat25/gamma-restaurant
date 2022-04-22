package com.example.gamma_restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;




public class ReviewsDisplay extends AppCompatActivity {

    // Global variables for database reference
    FirebaseDatabase mDatabase;
    DatabaseReference myRef;


    TextView name, date, review_message;
    ImageButton close, addReview;
    RatingBar ratingBar, ratingAverage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviews_display);

        // Get the TextViews by their IDs
        name = (TextView)findViewById(R.id.CustomerName);
        date = (TextView)findViewById(R.id.date);
        review_message = (TextView)findViewById(R.id.review_message);

        // Get the buttons by their IDs
        close = (ImageButton) findViewById(R.id.close);
       // refresh = (ImageButton)findViewById(R.id.refresh);
        addReview = (ImageButton) findViewById(R.id.AddReviewButton);

        // Get the Rating Bar by its ID
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        ratingAverage = (RatingBar)findViewById(R.id.AverageRatingBar);

        // Get instance of the firebase database
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = mDatabase.getReference("Review/Customer");


        // Retrieve data from database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                // Get the username from database
                String username = dataSnapshot.child("username").getValue(String.class);
                name.setText(username);

                // Get the date
                String reviewDate = dataSnapshot.child("date").getValue(String.class);
                date.setText(reviewDate);

                // Get the review message
                String reviewMessage = dataSnapshot.child("feedback_message").getValue(String.class);
                review_message.setText(reviewMessage);

                // Get the value of rating bar
                int ratingValue = dataSnapshot.child("rating").getValue(int.class);
                ratingBar.setRating(ratingValue);
                ratingAverage.setRating(ratingValue);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        // When the "close" button is pressed display the "Home" page
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openMainActivity();
            }
        });

        // When the "Add Review" button is pressed display the "Rate Restaurant" page
        addReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openRateRestaurant();
            }
        });



    }


    // Home Activity Method
    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // Rate Restaurant Activity Method
    public void openRateRestaurant(){
        Intent intent = new Intent(this, RateRestaurant.class);
        startActivity(intent);
    }




}
