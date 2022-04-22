package com.example.gamma_restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class ServiceType extends AppCompatActivity {

    ImageButton cancel;
    RadioButton roomDelivery, pickUp, dineIn;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_type);

        // Get the cancel & submit buttons by their ID
        cancel = (ImageButton) findViewById(R.id.cancel_button);
        submit = (Button) findViewById(R.id.submit);

        // Get the radio buttons by their IDs
        RadioButton roomDelivery = (RadioButton) findViewById(R.id.room_delivery);
        RadioButton pickUp = (RadioButton) findViewById(R.id.pick_up);
        RadioButton dineIn = (RadioButton) findViewById(R.id.dine_in);


        // See which radio button was selected
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If "Deliver to Hotel Room" is selected open the Room Delivery Form Activity
                if (roomDelivery.isChecked()) {
                    openRoomDeliveryForm();
                }
                // If "Pick-Up" is selected open the Pick-Up Form Activity
                else if (pickUp.isChecked()) {
                     openPickUpForm();
                }
                // If "Dine-In" is selected open the Reservations Activity Activity
                else if (dineIn.isChecked()) {
                     openReservationsActivity();
                }
            }
        });



        // When the cancel button is pressed go back to Menu Options
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openMenu();

            }
        });
    }

    // Menu Options Activity Method
    public void openMenu() {
        Intent intent = new Intent(this, FoodMenuActivity.class);
        startActivity(intent);
    }

    // Room Delivery Form Activity Method
    public void openRoomDeliveryForm() {
        Intent intent = new Intent(this, RoomDeliveryForm.class);
        startActivity(intent);
    }

    // Pick Up Order Form Activity Method
    public void openPickUpForm() {
        Intent intent = new Intent(this, PickUpForm.class);
        startActivity(intent);
    }

    // Reservations Activity Method
    public void openReservationsActivity() {
        Intent intent = new Intent(this, ReservationsActivity.class);
        startActivity(intent);
    }

}
