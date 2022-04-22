package com.example.gamma_restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class shellsActivity extends AppCompatActivity {

    Button order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shells);

        // Get order button by its ID
        order = (Button) findViewById(R.id.order);

        // Get instance of database
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = mDatabase.getReference("Order");

        // When the order button is pressed update the food order in database then go to the "Service Type" page
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Map<String, Object> mHashmap = new HashMap<>();
                mHashmap.put("Food", "STUFFED SHELLS"); // update food order

                // Perform database update
                myRef.updateChildren(mHashmap);

                openServiceType();

            }
        });
    }

    // Service Type Activity Method
    public void openServiceType() {
        Intent intent = new Intent(this, ServiceType.class);
        startActivity(intent);
    }


}