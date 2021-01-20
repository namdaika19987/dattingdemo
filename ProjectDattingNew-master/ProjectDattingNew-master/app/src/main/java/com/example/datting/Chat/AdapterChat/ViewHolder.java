package com.example.datting.Chat.AdapterChat;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datting.BottomNavigation.Chat_Fragments;
import com.example.datting.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ViewHolder extends RecyclerView.ViewHolder {
    CircleImageView image_status, image_mess;
    TextView name_status, name_mess, message, time, soluong;

    TextView message_mqtt;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        //status
        image_status = itemView.findViewById(R.id.image_status);
        name_status = itemView.findViewById(R.id.name_status);

        ///Chat

        image_mess = itemView.findViewById(R.id.image_mess);
        name_mess = itemView.findViewById(R.id.name_mess);
        time = itemView.findViewById(R.id.time);
        message = itemView.findViewById(R.id.message);
        soluong = itemView.findViewById(R.id.soluong);

        // Message
        message_mqtt= itemView.findViewById(R.id.message);

    }

}
