package com.example.gamma_restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class ReservationsActivity extends AppCompatActivity implements View.OnClickListener {

    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);

        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button10 = findViewById(R.id.button10);
        Button button11 = findViewById(R.id.button11);
        Button button12 = findViewById(R.id.button12);
        ImageButton back = findViewById(R.id.back);


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        back.setOnClickListener(this);

        // Get instance of database
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        myRef = mDatabase.getReference("Reservations");

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        // Hashmap for database
        Map<String, Object> mHashmap = new HashMap<>();

        switch (v.getId()) {
            case R.id.button:
                Intent intent1 = new Intent(ReservationsActivity.this, ReservationFormActivity.class);
                mHashmap.put("Reservation for", "Table 1"); // update the table number
                startActivity(intent1);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(ReservationsActivity.this, ReservationFormActivity.class);
                mHashmap.put("Reservation for", "Table 2"); // update the table number
                startActivity(intent2);
                break;
            case R.id.button3:
                Intent intent3 = new Intent(ReservationsActivity.this, ReservationFormActivity.class);
                mHashmap.put("Reservation for", "Table 3"); // update the table number
                startActivity(intent3);
                break;
            case R.id.button4:
                Intent intent4 = new Intent(ReservationsActivity.this, ReservationFormActivity.class);
                mHashmap.put("Reservation for", "Table 4"); // update the table number
                startActivity(intent4);
                break;
            case R.id.button5:
                Intent intent5 = new Intent(ReservationsActivity.this, ReservationFormActivity.class);
                mHashmap.put("Reservation for", "Table 5"); // update the table number
                startActivity(intent5);
                break;
            case R.id.button6:
                Intent intent6 = new Intent(ReservationsActivity.this, ReservationFormActivity.class);
                mHashmap.put("Reservation for", "Table 6"); // update the table number
                startActivity(intent6);
                break;
            case R.id.button7:
                Intent intent7 = new Intent(ReservationsActivity.this, ReservationFormActivity.class);
                mHashmap.put("Reservation for", "Table 7"); // update the table number
                startActivity(intent7);
                break;
            case R.id.button8:
                Intent intent8 = new Intent(ReservationsActivity.this, ReservationFormActivity.class);
                mHashmap.put("Reservation for", "Table 8"); // update the table number
                startActivity(intent8);
                break;
            case R.id.button9:
                Intent intent9 = new Intent(ReservationsActivity.this, ReservationFormActivity.class);
                mHashmap.put("Reservation for", "Table 9"); // update the table number
                startActivity(intent9);
                break;
            case R.id.button10:
                Intent intent10 = new Intent(ReservationsActivity.this, ReservationFormActivity.class);
                mHashmap.put("Reservation for", "Table 10"); // update the table number
                startActivity(intent10);
                break;
            case R.id.button11:
                Intent intent11 = new Intent(ReservationsActivity.this, ReservationFormActivity.class);
                mHashmap.put("Reservation for", "Table 11"); // update the table number
                startActivity(intent11);
                break;
            case R.id.button12:
                Intent intent12 = new Intent(ReservationsActivity.this, ReservationFormActivity.class);
                mHashmap.put("Reservation for", "Table 12"); // update the table number
                startActivity(intent12);
                break;
            case R.id.back:
                Intent intent13 = new Intent(ReservationsActivity.this, MainActivity.class);
                startActivity(intent13);
                break;

        }

        // Perform database update
        myRef.updateChildren(mHashmap);
    }
}