package com.example.datting.Chat.AdapterChat;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datting.Chat.MessageActivity;
import com.example.datting.Model.Message;
import com.example.datting.R;

import java.util.ArrayList;


public class AdapterMessage extends RecyclerView.Adapter<ViewHolder> {
    String[] output;
    Context context;
    ArrayList<Message> messages;
    Message message;

    public AdapterMessage(Context context, ArrayList<Message> messages) {
        this.context = context;
        this.messages = messages;
    }

    @Override
    public int getItemViewType(int position) {
        message = messages.get(position);

        if (message.getMessage().contains(Build.USER)) {
            return 0;

        } else {
            return 1;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sefl, parent, false);
            return new ViewHolder(view);
        } else if (viewType == 1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friends, parent, false);
            return new ViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.message_mqtt.setText(message.getMessage().replace("android-build:", ""));
        message = messages.get(position);
        String mess = message.getMessage();
        holder.message_mqtt.setText(mess.substring(mess.lastIndexOf(":")+1));
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}
