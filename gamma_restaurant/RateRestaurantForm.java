package com.example.gamma_restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class RateRestaurantForm extends AppCompatActivity {

    TextView name, date;
    ImageButton back, done;
    RatingBar ratingBar;
    EditText feedbackMessage;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_restaurant_form);



        String dateTime;
        Calendar calendar;
        SimpleDateFormat simpleDateFormat;

        // Get the Text Views by their ID
        name = (TextView)findViewById(R.id.CustomerName);
        date = (TextView)findViewById(R.id.date);
        feedbackMessage = (EditText) findViewById(R.id.review_message);

        // Get Image Buttons by their IDs
        back = (ImageButton)findViewById(R.id.back);
        done = (ImageButton)findViewById(R.id.done);

        // Get the Rating Bar by its ID
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);

        // Get customer's first and last name from the previous activity
        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        name.setText(str);


        // Display the current date
        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("MMM d, yyyy");
        dateTime = simpleDateFormat.format(calendar.getTime()).toString();
        date.setText(dateTime);

        // Get instance of database
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = mDatabase.getReference("Review/Customer");

        


        // When the back button is pressed go back to the "Enter Your Name" page
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openRateRestaurant();

            }
        });


        // When the done button is pressed go to the "Thanks For Feedback" page
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Convert review message into a string
                String message = feedbackMessage.getText().toString();

                // Get value of rating bar
                float rating = ratingBar.getRating();

                // Update the "date" and "feedback message" in the firebase database
                Map<String, Object> mHashmap = new HashMap<>();
                mHashmap.put("date", dateTime); // update the date
                mHashmap.put("feedback_message", message); // update the feedback message
                mHashmap.put("rating", rating); // update the value of the rating bar

                // Perform database update
                myRef.updateChildren(mHashmap);

                // Go to "Thanks for Feedback" activity
                openThanksForFeedback();
            }

        });
    }

    // Reviews Options Activity Method
     public void openReviewsOptions() {
        Intent intent = new Intent(this, ReviewsOptions.class);
        startActivity(intent);
    }

    // Thanks For Feedback Activity Method
    public void openThanksForFeedback() {
        Intent intent = new Intent(this, ThanksForFeedback.class);
        startActivity(intent);
    }

    // Rate Restaurant Activity Method
    public void openRateRestaurant() {
        Intent intent = new Intent(this, RateRestaurant.class);
        startActivity(intent);
    }




}
