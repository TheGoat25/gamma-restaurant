package com.example.gamma_restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class FoodMenuActivity extends AppCompatActivity {

    private Button button4, butSteak, button5, button6, button2, button7, button8, button3, button9;
    ImageButton close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);

        // Get the cancel button by its ID
        close = (ImageButton) findViewById(R.id.close_button);

        initViews();

        // When the cancel button is pressed go back to Home activity
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openHome();

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent braciole = new Intent(FoodMenuActivity.this, bracioleActivity.class);
                startActivity(braciole);
            }
        });

        butSteak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent seafoodP = new Intent(FoodMenuActivity.this, seafoodpActivity.class);
                startActivity(seafoodP);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chickenP = new Intent(FoodMenuActivity.this, chickenActivity.class);
                startActivity(chickenP);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent meatballs = new Intent(FoodMenuActivity.this, meatballsActivity.class);
                startActivity(meatballs);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shells = new Intent(FoodMenuActivity.this, shellsActivity.class);
                startActivity(shells);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lasagna = new Intent(FoodMenuActivity.this, lasagnaActivity.class);
                startActivity(lasagna);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent margherita = new Intent(FoodMenuActivity.this, margheritaActivity.class);
                startActivity(margherita);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent napoletana = new Intent(FoodMenuActivity.this, napoletanaActivity.class);
                startActivity(napoletana);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calzone = new Intent(FoodMenuActivity.this, calzoneActivity.class);
                startActivity(calzone);
            }
        });

    }

    private void initViews() {

        button4 = findViewById(R.id.button4);
        butSteak = findViewById(R.id.butSteak);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button2 = findViewById(R.id.button2);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button3 = findViewById(R.id.button3);
        button9 = findViewById(R.id.button9);

    }

    // Home Activity Method
    public void openHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}