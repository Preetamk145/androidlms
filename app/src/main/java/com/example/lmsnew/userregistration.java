package com.example.lmsnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class userregistration extends AppCompatActivity {

    EditText name,usn,branch,email,password;
    Button register;
    FirebaseAuth auth;
    FirebaseFirestore fire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userregistration);
        name=findViewById(R.id.name);
        usn=findViewById(R.id.usntext);
        branch=findViewById(R.id.branch);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        register=findViewById(R.id.register);
        auth=FirebaseAuth.getInstance();
        fire=FirebaseFirestore.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getname=name.getText().toString();
                String  getusn=usn.getText().toString();
                String  getbranch=branch.getText().toString();
                String getemail=email.getText().toString();
                String  getpassword=password.getText().toString();
                auth.createUserWithEmailAndPassword(getemail,getpassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        FirebaseUser usr = auth.getCurrentUser();

                        DocumentReference ref = fire.collection("userinfo").document(usr.getUid());

                        HashMap <String,Object> userinfo = new HashMap<>();
                        userinfo.put("name",getname);
                        userinfo.put("usn",getusn);
                        userinfo.put("branch",getbranch);

                        ref.set(userinfo).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(userregistration.this, "registration successful", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(userregistration.this,AdminManinActivity.class));
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(userregistration.this, "registration Failed2", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(userregistration.this, "registration Failed1", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}