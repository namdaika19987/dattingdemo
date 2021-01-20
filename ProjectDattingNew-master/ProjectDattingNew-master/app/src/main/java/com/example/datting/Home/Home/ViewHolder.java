package com.example.datting.Home.Home;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datting.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ViewHolder extends RecyclerView.ViewHolder {

    public CircleImageView image1, image_status;
    public TextView name1;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        image_status = itemView.findViewById(R.id.image_status);
        image1 = itemView.findViewById(R.id.image_home);
        name1 = itemView.findViewById(R.id.name_home);



    }
}
