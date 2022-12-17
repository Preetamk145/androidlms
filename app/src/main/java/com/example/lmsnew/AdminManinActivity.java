package com.example.lmsnew;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AdminManinActivity extends AppCompatActivity {

    View adduser;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_manin);
        adduser=findViewById(R.id.user);

        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminManinActivity.this,add_user.class);
                startActivity(intent);

            }
        });

    }
}