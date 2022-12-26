package com.example.lmsnew;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Takebook extends AppCompatActivity {
    EditText removebookusn,removebookid;
    Button takebook;
    BottomNavigationView bootomnavbar;
    FirebaseAuth auth;
    FirebaseFirestore fire;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takebook);
        removebookusn=findViewById(R.id.removebookusn);
        removebookid=findViewById(R.id.removebookid);
        takebook=findViewById(R.id.removebook);
        bootomnavbar=findViewById(R.id.bottomNavigationView);
        bootomnavbar.setSelectedItemId(R.id.givebook);
        auth=FirebaseAuth.getInstance();
        fire=FirebaseFirestore.getInstance();
        bootomnavbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.givebook:
                        return  true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext(),add_user.class));
                        overridePendingTransition(0,0);
                        return  true;
                    case R.id.booklist:
                        startActivity(new Intent(getApplicationContext(),booklist.class));
                        overridePendingTransition(0,0);
                        return true;


                }
                return false;
            }
        });

    }
}