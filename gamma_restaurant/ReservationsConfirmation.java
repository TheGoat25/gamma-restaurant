package com.example.gamma_restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ReservationsConfirmation extends AppCompatActivity {

    ImageButton close;
    TextView table_number, time;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservations_confirmation);

        // Get the close button by its ID
        close = (ImageButton) findViewById(R.id.close);

        // Get the TextViews by their IDs
        table_number = (TextView) findViewById(R.id.table_number);
        time = (TextView) findViewById(R.id.time);


        // Get instance of database
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = mDatabase.getReference("Reservations");



        // Retrieve data from database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                // Get the name from database
                String tableNumber = dataSnapshot.child("Reservation for").getValue(String.class);
                table_number.setText(tableNumber);

                // Get the time from database
                String reservationTime = dataSnapshot.child("Time").getValue(String.class);
                time.setText(reservationTime);

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
    }

    // Home Activity Method
    public void openHomeActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
