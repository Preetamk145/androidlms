package com.example.lmsnew;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class UserMainActivity extends AppCompatActivity {

   FirebaseAuth auth;
   FirebaseFirestore frs;
   TextView usn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        auth=FirebaseAuth.getInstance();
        frs=FirebaseFirestore.getInstance();
        usn=findViewById(R.id.usntext);

    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser usr = auth.getCurrentUser();
        DocumentReference ref = frs.collection("userinfo").document(usr.getUid());
        ref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                    String usnt = documentSnapshot.getString("usn");
                     usn.setText(usnt);


            }
        });

    }
}