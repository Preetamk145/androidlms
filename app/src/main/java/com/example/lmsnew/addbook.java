package com.example.lmsnew;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

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
                String getid=bookid.getText().toString();
                String  getname=name.getText().toString();
                String  getauthor=author.getText().toString();
                DocumentReference ref = fire.collection("booktable").document();

                HashMap<String,Object> booktable = new HashMap<>();
                booktable.put("id",getid);
                booktable.put("name",getname);
                booktable.put("author name",getauthor);
                ref.set(booktable).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(addbook.this, "registration successful", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(addbook.this,userregistration.class));
                    }
                });

            }
        });



    }
}