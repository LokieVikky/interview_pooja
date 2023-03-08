package com.acsass.interview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends AppCompatActivity {

    public static List<String> menu = new ArrayList<>();

    EditText edtFoodName;
    Button btnAddFood;
    ListView lstMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        edtFoodName = findViewById(R.id.edtFoodName);
        btnAddFood = findViewById(R.id.btnAddFood);
        lstMenu = findViewById(R.id.lstMenu);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menu);
        lstMenu.setAdapter(adapter);

        btnAddFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String foodName = edtFoodName.getText().toString();
                if (foodName.isEmpty()) {
                    Toast.makeText(AdminActivity.this, "Enter food name to add", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (menu.contains(foodName)) {
                    Toast.makeText(AdminActivity.this, foodName + " already exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                menu.add(foodName);
                adapter.notifyDataSetChanged();
            }
        });


    }
}