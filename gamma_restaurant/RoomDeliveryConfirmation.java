package com.example.gamma_restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class RoomDeliveryConfirmation extends AppCompatActivity {

    ImageButton close;
    TextView name;
    Button orderSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_delivery_confirmation);

        // Get buttons by their IDs
        close = (ImageButton) findViewById(R.id.close);
        orderSummary = (Button) findViewById(R.id.ViewOrder);

        // Get the TextViews by their IDs
        name = (TextView)findViewById(R.id.CustomerName);

        // Get instance of database
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = mDatabase.getReference("Order");

        // Retrieve data from database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                // Get the name for the order from database
                String username = dataSnapshot.child("Full Name").getValue(String.class);
                name.setText(username);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // When the close button is pressed go back to Main Activity
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openHomeActivity();

            }
        });

        // When the Order Summary button is pressed go to "Order Summary" Activity
        orderSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openOrderSummary();

            }
        });

    }

    // Home Activity Method
    public void openHomeActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // Order Summary Activity Method
    public void openOrderSummary() {
        Intent intent = new Intent(this, OrderSummary.class);
        startActivity(intent);
    }
}
