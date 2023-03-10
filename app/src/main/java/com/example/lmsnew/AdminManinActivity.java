package com.example.lmsnew;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AdminManinActivity extends AppCompatActivity {
     BottomNavigationView bootomnavbar;
     Button b1,b2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_manin);
        bootomnavbar=findViewById(R.id.bottomNavigationView);
        b1=findViewById(R.id.givbook);
        b2=findViewById(R.id.takebook);
        bootomnavbar.setSelectedItemId(R.id.givebook);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminManinActivity.this,GiveBook.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminManinActivity.this,Takebook.class);
                startActivity(intent);
            }
        });
        bootomnavbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.booklist:
                        startActivity(new Intent(getApplicationContext(),booklist.class));
                        overridePendingTransition(0,0);
                        return  true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext(),add_user.class));
                        overridePendingTransition(0,0);
                        return  true;
                    case R.id.givebook:
                        return true;


                }
                return false;
            }
        });

    }
}