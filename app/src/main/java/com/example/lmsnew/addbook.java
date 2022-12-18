package com.example.lmsnew;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class addbook extends AppCompatActivity {

    EditText bookid,name,author;
    Button add;
    FirebaseAuth auth;
    FirebaseFirestore fire;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbook);
        bookid=findViewById(R.id.bookid);
        name=findViewById(R.id.bookname);
        author=findViewById(R.id.author);
        add=findViewById(R.id.add);
        auth=FirebaseAuth.getInstance();
        fire=FirebaseFirestore.getInstance();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }
}