package com.example.gamma_restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class PickUpForm extends AppCompatActivity {

    ImageButton cancel;
    Button submit;
    EditText customer_name, email, phone_number, special_instructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.pick_up_form);

        // Get the cancel and submit buttons by their IDs
        cancel = (ImageButton) findViewById(R.id.cancel_button);
        submit = (Button) findViewById(R.id.submit);

        // Get the EditTexts by their IDs
        customer_name = (EditText) findViewById(R.id.CustomerName);
        email = (EditText) findViewById(R.id.Email);
        phone_number = (EditText) findViewById(R.id.CellphoneNumber);
        special_instructions = (EditText) findViewById(R.id.special_instructions);

        // Get instance of database
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = mDatabase.getReference("Order");


        // When the cancel button is pressed go back to "Service Type" Activity
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openServiceType();

            }
        });


        // When the submit button is pressed record all the user's info in the database then go to "Room Delivery Confirmation" Activity
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Convert all EditTexts into strings
                String fullName  = customer_name.getText().toString();
                String customer_email  = email.getText().toString();
                String cellphoneNumber  = phone_number.getText().toString();
                String specialInstructions  = special_instructions.getText().toString();



                // Update the "date" and "feedback message" in the firebase database
                Map<String, Object> mHashmap = new HashMap<>();
                mHashmap.put("Full Name", fullName); // update customer's name
                mHashmap.put("Email", customer_email); // update the email
                mHashmap.put("Cellphone Number", cellphoneNumber); // update cellphone #
                mHashmap.put("Special Instructions", specialInstructions); // update special instructions
                mHashmap.put("Service Type", "Pick-Up Order"); // update the service type
                mHashmap.put("Payment Type", "Cash"); // update the payment type



                // Perform database update
                myRef.updateChildren(mHashmap);

               openPickUpFormConfirmation();

            }

        });
    }

    // Service Type Activity Method
    public void openServiceType() {
        Intent intent = new Intent(this, ServiceType.class);
        startActivity(intent);
    }

    // Pick-Up Form Confirmation Activity Method
    public void openPickUpFormConfirmation() {
        Intent intent = new Intent(this, PickUpConfirmation.class);
        startActivity(intent);
    }
}
