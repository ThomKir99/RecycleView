package com.example.thomas.cours13;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TodoRecycleAdapter extends RecyclerView.Adapter<TodoRecycleAdapter.MyViewHolder>{

    List<Todo> todoList;

    public TodoRecycleAdapter(List<Todo> todoList) {
        this.todoList = todoList;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
    TextView titre;
    TextView description;
    TextView date;
        public MyViewHolder(View itemView) {
            super(itemView);
            titre = itemView.findViewById(R.id.textView_Title);
            description = itemView.findViewById(R.id.textView_description);
            date = itemView.findViewById(R.id.textView_date);
        }
    }

    @NonNull
    @Override
    public TodoRecycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_card,parent,false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TodoRecycleAdapter.MyViewHolder holder, int position) {
        Todo todeToDisplay = todoList.get(position);
        holder.titre.setText(todeToDisplay.getTitle());
        holder.description.setText(todeToDisplay.getDescription());
        holder.date.setText(todeToDisplay.getDateAdded().toString());
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }
}
