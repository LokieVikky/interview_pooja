package com.acsass.interview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FoodDetailsActivity extends AppCompatActivity {

    TextView txtFoodName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
        txtFoodName = findViewById(R.id.txtFoodName);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        String foodName = b.getString("FoodName");
        txtFoodName.setText("You clicked on \n"+foodName);
    }
}