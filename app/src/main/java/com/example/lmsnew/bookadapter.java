package com.example.lmsnew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        booktable booktable=book.get(position);
        holder.authorname.setText(booktable.authorname);
        holder.bookname.setText(booktable.name);
        holder.bookid.setText(booktable.id);

    }

    @Override
    public int getItemCount() {
        return book.size();
    }

    public class viewholderbook extends RecyclerView.ViewHolder {
        TextView bookname,bookid,authorname;
        public viewholderbook(@NonNull View itemView) {
            super(itemView);
            bookid= itemView.findViewById(R.id.idbook);
            bookname=itemView.findViewById(R.id.namebook);
            authorname= itemView.findViewById(R.id.nameauthor);
        }
    }
}
