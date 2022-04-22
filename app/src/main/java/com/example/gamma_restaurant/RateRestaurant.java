package com.example.gamma_restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class RateRestaurant<SimpleCursorAdapter> extends AppCompatActivity {

    EditText first_name, last_name;
    ImageButton cancel;
    Button submit;



    // Implement the TextWatcher
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            // get the content of both the edit text
            String firstName = first_name.getText().toString();
            String lastName = last_name.getText().toString();

            // Enable submit button after both input fields are filled in
            submit.setEnabled(!firstName.isEmpty() && !lastName.isEmpty());


        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_restaurant);


        // Get submit button by its ID and disable it
        submit = (Button) findViewById(R.id.submit);
        submit.setEnabled(false);

        // Get the cancel button by its ID
        cancel = (ImageButton) findViewById(R.id.cancel);

        // Get the input fields by ID
        first_name = (EditText) findViewById(R.id.first_name);
        last_name = (EditText) findViewById(R.id.last_name);


        // Set TextChange Listener for both input fields
        first_name.addTextChangedListener(textWatcher);
        last_name.addTextChangedListener(textWatcher);


        // Get instance of database
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = mDatabase.getReference("Review/Customer");



        // When the cancel button is pressed go back to Reviews Display
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openReviewsDisplay();

            }
        });

        // When the submit button is pressed open up Rate Restaurant Form
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Combine customer's first and last name into one string
                String str = first_name.getText().toString() + " " + last_name.getText().toString();

                //Writing Hashmap
                Map<String, Object> mHashmap = new HashMap<>();
                mHashmap.put("username", str); // update username

                // Perform database update
                myRef.updateChildren(mHashmap);

                // Send customer's first and last name to the "Rate Restaurant Form"
                Intent intent = new Intent(getApplicationContext(), RateRestaurantForm.class);
                intent.putExtra("message_key", str);

                startActivity(intent);

            }
        });
    }

    private void setContentView(TextView tv) {
    }


    // Reviews Options Activity Method
    public void openReviewsDisplay() {
        Intent intent = new Intent(this, ReviewsDisplay.class);
        startActivity(intent);
    }
}
