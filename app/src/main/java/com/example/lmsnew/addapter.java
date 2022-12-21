package com.example.lmsnew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;

public class addapter extends RecyclerView.Adapter<addapter.MyviewHolder> {
    Context context;
    ArrayList<User>list;

    public addapter(ArrayList<User> list) {
        this.list = list;
    }

    public addapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public addapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view v= LayoutInflater.from(context).inflate(R.layout.bookitem,parent,false);
        return new MyviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull addapter.MyviewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
