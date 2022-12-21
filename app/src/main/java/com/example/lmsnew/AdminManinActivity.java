package com.example.lmsnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AdminManinActivity extends AppCompatActivity {
     BottomNavigationView bootomnavbar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_manin);
        bootomnavbar=findViewById(R.id.bottomNavigationView);
        bootomnavbar.setSelectedItemId(R.id.givebook);
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