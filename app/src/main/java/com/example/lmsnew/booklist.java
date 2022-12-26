package com.example.lmsnew;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class booklist extends AppCompatActivity {

    Button addbook;
    BottomNavigationView bootomnavbar;
    ArrayList<booktable> booktables;
    RecyclerView rcvbook;
    bookadapter bookadapter;
    FirebaseFirestore fstore;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booklist);
        addbook = findViewById(R.id.addbook);
        bootomnavbar = findViewById(R.id.bottomNavigationView);
        bootomnavbar.setSelectedItemId(R.id.booklist);
        rcvbook=findViewById(R.id.rvbook);
        addbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(booklist.this, addbook.class);
                startActivity(intent);
            }
        });
        rcvbook.setHasFixedSize(true);
        rcvbook.setLayoutManager(new LinearLayoutManager(this));
        booktables = new ArrayList<booktable>();
        bookadapter = new bookadapter(booklist.this,booktables);
        rcvbook.setAdapter(bookadapter);
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
    private void display_data() {
        fstore = FirebaseFirestore.getInstance();
        fstore.collection("booktable").
               addSnapshotListener(new EventListener<QuerySnapshot>() {
                   @Override
                   public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                       if(error!=null)
                       {
                           Log.d("error : ",error.getMessage());
                           return;
                       }
                       for(DocumentChange dc : value.getDocumentChanges())
                       {
                           if(dc.getType()== DocumentChange.Type.ADDED)
                           {
                               booktables.add(dc.getDocument().toObject(booktable.class));
                           }
                           bookadapter.notifyDataSetChanged();
                       }

                   }
               });


    }

}