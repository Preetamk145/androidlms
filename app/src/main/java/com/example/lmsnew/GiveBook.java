package com.example.lmsnew;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class GiveBook extends AppCompatActivity {
    EditText usnaddbook,addbookid,booktitle,date;
    Button givebook;
    BottomNavigationView bootomnavbar;
    FirebaseAuth auth;
    FirebaseFirestore fire;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_book);
        usnaddbook=findViewById(R.id.addbookusn);
        addbookid=findViewById(R.id.bookadid);
        booktitle=findViewById(R.id.booktitle);
        givebook=findViewById(R.id.bookadd);
        date=findViewById(R.id.date);
        bootomnavbar=findViewById(R.id.bottomNavigationView);
        bootomnavbar.setSelectedItemId(R.id.givebook);
        auth=FirebaseAuth.getInstance();
        fire=FirebaseFirestore.getInstance();
        givebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getaddbookusn=usnaddbook.getText().toString();
                String  getaddbookid=addbookid.getText().toString();
                String  getaddtitle=booktitle.getText().toString();
                String getadddate=date.getText().toString();
                DocumentReference ref = fire.collection("booktransaction").document();

                HashMap<String,Object> booktransaction = new HashMap<>();
                booktransaction.put("usn",getaddbookusn);
                booktransaction.put("bookid",getaddbookid);
                booktransaction.put("bookname",getaddtitle);
                booktransaction.put("duedate",getadddate);
                ref.set(booktransaction).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(GiveBook.this, "book added successful", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(GiveBook.this,AdminManinActivity.class));
                    }
                });


            }
        });
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