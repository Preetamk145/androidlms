package com.example.lmsnew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class bookadapter extends RecyclerView.Adapter<bookadapter.viewholderbook> {
    ArrayList<booktable> book;
    Context context;
    public bookadapter(Context context, ArrayList<booktable> book) {
        this.context=context;
        this.book=book;
    }

    @NonNull
    @Override
    public bookadapter.viewholderbook onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View bookv= LayoutInflater.from(context).inflate(R.layout.singlebookitem,parent,false);
        return null;

    }

    @Override
    public void onBindViewHolder(@NonNull bookadapter.viewholderbook holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class viewholderbook extends RecyclerView.ViewHolder {
        public viewholderbook(@NonNull View itemView) {
            super(itemView);
        }
    }
}
