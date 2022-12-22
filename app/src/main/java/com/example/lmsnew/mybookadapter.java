package com.example.lmsnew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class mybookadapter extends RecyclerView.Adapter<mybookadapter.MyviewHolder> {
    Context context;
    ArrayList<bookdata> list;

    public mybookadapter(Context context, ArrayList<bookdata> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.bookitem,parent,false);
        return new MyviewHolder(v);


    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {

        bookdata bookdata=list.get(position);
        holder.bookname.setText(bookdata.getBookname());
        holder.bookid.setText(bookdata.getBookid());
        holder.authorname.setText(bookdata.getAuthorname());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder{
        TextView bookname,bookid,authorname;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);

            bookname=itemView.findViewById(R.id.namebook);
            bookid=itemView.findViewById(R.id.idbook);
            authorname=itemView.findViewById(R.id.nameauthor);

        }
    }
}
