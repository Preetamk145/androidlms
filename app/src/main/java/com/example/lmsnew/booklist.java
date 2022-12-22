package com.example.lmsnew;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class booklist extends AppCompatActivity {

    Button addbook;
    BottomNavigationView bootomnavbar;
    ArrayList<bookdata> list;
    DatabaseReference dr;
    mybookadapter mybookadapter;
    RecyclerView rv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booklist);
        addbook = findViewById(R.id.addbook);
        bootomnavbar = findViewById(R.id.bottomNavigationView);
        bootomnavbar.setSelectedItemId(R.id.booklist);
        rv=findViewById(R.id.rvbook);
        dr= FirebaseDatabase.getInstance().getReference("booktable");
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        mybookadapter=new mybookadapter(this,list);
        rv.setAdapter(mybookadapter);
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    bookdata bookdata=dataSnapshot.getValue(com.example.lmsnew.bookdata.class);
                    list.add(bookdata);
                }
                mybookadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        addbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(booklist.this, addbook.class);
                startActivity(intent);
            }
        });
        bootomnavbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.booklist:
                        return true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext(), add_user.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.givebook:
                        startActivity(new Intent(getApplicationContext(), AdminManinActivity.class));
                        overridePendingTransition(0, 0);
                        return true;


                }
                return false;
            }
        });

    }

}