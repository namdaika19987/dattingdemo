package com.example.datting.Chat.AdapterChat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.datting.Chat.MessageActivity;
import com.example.datting.Model.PeopleClass;
import com.example.datting.R;

import java.util.ArrayList;

public class AdapterStatus extends RecyclerView.Adapter<ViewHolder> {
    ArrayList<PeopleClass> peopleClasses;
    Context context;

    public AdapterStatus(ArrayList<PeopleClass> peopleClasses, Context context) {
        this.peopleClasses = peopleClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_status, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final PeopleClass people = peopleClasses.get(position);
        //holder.image_status.setImageResource(people.getImage());
        Glide.with(context).load(people.getImage()).into(holder.image_status);
        holder.name_status.setText(people.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Toast.makeText(context, "hieuthanh", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, MessageActivity.class);
                intent.putExtra("image",people.getImage());
                intent.putExtra("name", people.getName());

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return peopleClasses.size();
    }
}
