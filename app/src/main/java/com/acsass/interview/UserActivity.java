package com.acsass.interview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class UserActivity extends AppCompatActivity {

    ListView lstMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        lstMenu = findViewById(R.id.lstMenu);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, AdminActivity.menu);
        lstMenu.setAdapter(adapter);
        lstMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String foodName = AdminActivity.menu.get(i);
                Intent intent = new Intent(UserActivity.this, FoodDetailsActivity.class);
                intent.putExtra("FoodName", foodName);
                startActivity(intent);
            }
        });
    }
}