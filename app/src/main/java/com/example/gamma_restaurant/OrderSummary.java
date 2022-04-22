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
import androidx.appcompat.app.AppCompatActivity;

public class OrderSummary extends AppCompatActivity {

    TextView serviceType, name, order, payment, roomNumber, contactNumber, email, specialInstructions;
    ImageButton close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_summary);


        // Get the TextViews by their IDs
        serviceType = (TextView)findViewById(R.id.ServiceType);
        name = (TextView)findViewById(R.id.CustomerName);
        order = (TextView)findViewById(R.id.Order);
        payment = (TextView)findViewById(R.id.Payment);
        roomNumber = (TextView)findViewById(R.id.RoomNumber);
        contactNumber = (TextView)findViewById(R.id.CellphoneNumber);
        email = (TextView)findViewById(R.id.Email);
        specialInstructions = (TextView)findViewById(R.id.SpecialInstructions);

        // Get the close button by its ID
        close = (ImageButton) findViewById(R.id.close);

        // Get instance of database
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = mDatabase.getReference("Order");

        // Retrieve data from database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                // Get the service type from database
                String service_type = dataSnapshot.child("Service Type").getValue(String.class);
                serviceType.setText(service_type);

                // Get the name for the order from database
                String name_for_order = dataSnapshot.child("Full Name").getValue(String.class);
                name.setText(name_for_order);

                // Get the order from database
                String orderItem = dataSnapshot.child("Food").getValue(String.class);
                order.setText(orderItem);

                // Get the payment type from database
                String paymentMethod = dataSnapshot.child("Payment Type").getValue(String.class);
                payment.setText(paymentMethod);

                // If customer is requesting Room Service then get hotel room number from database
                if (service_type == "Room Service") {
                    // Get the room number from database
                    String room_number = dataSnapshot.child("Hotel Room Number").getValue(String.class);
                    roomNumber.setText(room_number);
                }
                // If customer is getting a pick-up order then leave the hotel room number blank
                else {
                    roomNumber.setText("");
                }

                // Get the cellphone number from database
                String cellphone_number = dataSnapshot.child("Cellphone Number").getValue(String.class);
                contactNumber.setText(cellphone_number);

                // Get the email from database
                String customer_email = dataSnapshot.child("Email").getValue(String.class);
                email.setText(customer_email);

                // Get the special instructions from database
                String additional_instructions = dataSnapshot.child("Special Instructions").getValue(String.class);
                specialInstructions.setText(additional_instructions);

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
