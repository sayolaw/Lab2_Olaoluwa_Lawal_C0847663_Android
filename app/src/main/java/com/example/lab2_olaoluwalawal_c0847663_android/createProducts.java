package com.example.lab2_olaoluwalawal_c0847663_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class createProducts extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_products);
        sqLiteDatabase = openOrCreateDatabase("employee_db",MODE_PRIVATE,null);
    }
    public void addProducts(View view){
                TextView tName = findViewById(R.id.name);
        TextView tDescription = findViewById(R.id.description);
        TextView tPrice = findViewById(R.id.price);
        String name = tName.getText().toString().trim();
        String description = tDescription.getText().toString().trim();
        String price = tPrice.getText().toString().trim();

        if(name.isEmpty()){
            tName.setError("name field is empty");
            tName.requestFocus();
            return;
        }
        if(description.isEmpty()){
            tDescription.setError("salary field is empty");
            tDescription.requestFocus();
            return;
        }
        if(price.isEmpty()){
            tPrice.setError("salary field is empty");
            tPrice.requestFocus();
            return;
        }
        String sql = "INSERT INTO products(name,description,price)"+
                "VALUES(?, ?, ?)";
        sqLiteDatabase.execSQL(sql,new String[]{name,description, price});
        Toast.makeText(createProducts.this, "Product has been added.", Toast.LENGTH_SHORT).show();

    }
    public void goBack(View view){
        startActivity(new Intent(this,MainActivity.class));
    }
}