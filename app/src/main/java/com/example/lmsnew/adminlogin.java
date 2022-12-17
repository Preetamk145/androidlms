package com.example.lmsnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class adminlogin extends AppCompatActivity {
    EditText aemail, apassword;
    Button alogin;
    FirebaseAuth auth;
    ProgressBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        aemail=findViewById(R.id.adminemail);
        apassword =findViewById(R.id.adminpassword);
        alogin=findViewById(R.id.adminloginbtn);
        auth= FirebaseAuth.getInstance();
        alogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=aemail.getText().toString().trim();
                String password= apassword.getText().toString().trim();
                if(TextUtils.isEmpty(email))
                {
                    aemail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    apassword.setError("password is required");
                    return;
                }
                if(password.length()<6)
                {
                    apassword.setError("password must be less than 6 character");
                    return;
                }
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            Toast.makeText(adminlogin.this, "loged in sucess fully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), AdminManinActivity.class));

                        }
                        else
                        {
                            Toast.makeText(adminlogin.this,"ERROR" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                        }

                    }


                });
            }
        });
    }

}