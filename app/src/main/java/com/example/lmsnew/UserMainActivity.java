package com.example.lmsnew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class UserMainActivity extends AppCompatActivity {

   FirebaseAuth auth;
   FirebaseFirestore frs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);

    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser usr = auth.getCurrentUser();
        DocumentReference ref = frs.collection("userinfo").document(usr.getUid());
        ref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                    String usn = documentSnapshot.getString("usn");
                    Toast.makeText(UserMainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();

            }
        });
    }
}