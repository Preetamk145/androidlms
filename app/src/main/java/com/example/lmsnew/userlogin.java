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

public class userlogin extends AppCompatActivity {
    EditText uemail, upassword;
    Button ulogin;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);
        uemail=findViewById(R.id.useremail);
        upassword =findViewById(R.id.userpassword);
        ulogin=findViewById(R.id.userloginbtn);
        auth= FirebaseAuth.getInstance();
        ulogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=uemail.getText().toString().trim();
                String password= upassword.getText().toString().trim();
                if(TextUtils.isEmpty(email))
                {
                    uemail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    upassword.setError("password is required");
                    return;
                }
                if(password.length()<6)
                {
                    upassword.setError("password must be less than 6 character");
                    return;
                }
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            Toast.makeText(userlogin.this, "loged in sucess fully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), UserMainActivity.class));

                        }
                        else
                        {
                            Toast.makeText(userlogin.this,"ERROR" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                        }

                    }


                });

            }
        });

    }
}