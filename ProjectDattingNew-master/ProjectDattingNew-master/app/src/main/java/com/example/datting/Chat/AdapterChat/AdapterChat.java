package com.example.datting.Chat.AdapterChat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.datting.BottomNavigation.Chat_Fragments;
import com.example.datting.Chat.MessageActivity;
import com.example.datting.Model.PeopleClass;
import com.example.datting.R;

import java.util.ArrayList;

public class AdapterChat extends RecyclerView.Adapter<ViewHolder> {
    ArrayList<PeopleClass> peopleClasses;
    Context context;

    public AdapterChat(ArrayList<PeopleClass> peopleClasses, Context context) {
        this.peopleClasses = peopleClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_chat, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final PeopleClass people = peopleClasses.get(position);

        // holder.image_mess.setImageResource(people.getImage());
        Glide.with(context).load(people.getImage()).into(holder.image_mess);

        //lay du lieu cua hoat dong
        if (people.isCheck_status() == true) {
            Glide.with(context).load(R.drawable.online).into(holder.image_status);
        } else {
            Glide.with(context).load(R.drawable.offline).into(holder.image_status);
        }

        holder.name_mess.setText(people.getName());
        holder.message.setText(people.getMessage());
        holder.time.setText(people.getTime());

        if (people.getSoluong() == 0 ||  people.getSoluong() < 0) {
            holder.soluong.setVisibility(View.GONE);
        }
        {
            holder.soluong.setText(String.valueOf(people.getSoluong()));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Toast.makeText(context, "hieuthanh", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, MessageActivity.class);
                intent.putExtra("image",people.getImage());
                intent.putExtra("name", people.getName());
                //truyền icon hoat dong
                //intent.putExtra("image_status", people.getImage_status());
                intent.putExtra("status_message",people.isCheck_status());

                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return peopleClasses.size();
    }
}
