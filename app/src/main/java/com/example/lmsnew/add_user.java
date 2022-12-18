package com.example.lmsnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class add_user extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.user_menu_admin,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.adduser)
        {
            Intent intent=new Intent(add_user.this,userregistration.class);
            startActivity(intent);
        }
        if(id==R.id.logout)
        {
            Intent intent=new Intent(add_user.this,MainActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}