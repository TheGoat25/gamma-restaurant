package com.example.gamma_restaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class ReservationFormActivity extends AppCompatActivity {

    EditText name, party_size, phone, time, special_requests;
    TextView tableNumber;
    ImageButton cancel;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_form);

        // Get the buttons by their IDs
        cancel = (ImageButton)findViewById(R.id.cancel);
        submit = (Button)findViewById(R.id.submit);

        // Get the TextView by its ID
        tableNumber = (TextView)findViewById(R.id.table_number);

        // Get the EditTexts by their IDs
        name = (EditText) findViewById(R.id.name);
        party_size = (EditText) findViewById(R.id.party_size);
        phone = (EditText) findViewById(R.id.phone);
        time = (EditText) findViewById(R.id.time);
        special_requests = (EditText) findViewById(R.id.special_requests);


        // Get instance of database
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = mDatabase.getReference("Reservations");

        // Get the table number from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                // Get table number
                String tableNum = dataSnapshot.child("Reservation for").getValue(String.class);
                tableNumber.setText(tableNum);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        // When the submit button is pressed record all the user's info in the database then go to "Reservation Confirmation" Activity
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Convert all EditTexts into strings
                String customerName  = name.getText().toString();
                String partySize = party_size.getText().toString();
                String phoneNumber = phone.getText().toString();
                String reservationTime = time.getText().toString();
                String specialRequests = special_requests.getText().toString();


                // Update the user's data in the database
                Map<String, Object> mHashmap = new HashMap<>();
                mHashmap.put("Name", customerName); // update the name
                mHashmap.put("Party Size", partySize); // update the party size
                mHashmap.put("Cellphone Number", phoneNumber); // update the cellphone number
                mHashmap.put("Time", reservationTime); // update the time
                mHashmap.put("Special Requests", specialRequests); // update the special requests


                // Perform database update
                myRef.updateChildren(mHashmap);

                openReservationConfirmation();

            }

        });






        // When the cancel button is pressed go back to the "Reservations Activity" page
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openReservationActivity();

            }
        });


    }

    // Reservations Activity Method
    public void openReservationActivity(){
        Intent intent = new Intent(this, ReservationsActivity.class);
        startActivity(intent);
    }

    // Reservation Confirmation Activity Method
    public void openReservationConfirmation(){
        Intent intent = new Intent(this, ReservationsConfirmation.class);
        startActivity(intent);
    }



}
