package com.example.lmsnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class booklist extends AppCompatActivity {

    Button addbook;
    Integer id;
    String bookname,authorname;
    BottomNavigationView bootomnavbar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booklist);
        addbook =findViewById(R.id.addbook);
        bootomnavbar=findViewById(R.id.bottomNavigationView);
        bootomnavbar.setSelectedItemId(R.id.booklist);
        addbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(booklist.this,addbook.class);
                startActivity(intent);
            }
        });
        bootomnavbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.booklist:
                        return  true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext(),add_user.class));
                        overridePendingTransition(0,0);
                        return  true;
                    case R.id.givebook:
                        startActivity(new Intent(getApplicationContext(),AdminManinActivity.class));
                        overridePendingTransition(0,0);
                        return true;


                }
                return false;
            }
        });

    }

}