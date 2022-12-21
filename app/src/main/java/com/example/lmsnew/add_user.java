package com.example.lmsnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class add_user extends AppCompatActivity {

    Button adduser;
    BottomNavigationView bootomnavbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        adduser =findViewById(R.id.addbook);
        bootomnavbar=findViewById(R.id.bottomNavigationView);
        bootomnavbar.setSelectedItemId(R.id.user);
        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(add_user.this,userregistration.class);
                startActivity(intent);
            }
        });
        bootomnavbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.user:
                        return  true;
                    case R.id.booklist:
                        startActivity(new Intent(getApplicationContext(),booklist.class));
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