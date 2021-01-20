package com.example.datting.Home.Home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.datting.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class People_Apdapter extends RecyclerView.Adapter<ViewHolder> {
    ArrayList<People> people;
    Context context;

    public People_Apdapter(ArrayList<People> people, Context context) {
        this.people = people;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_home, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final People people1 = people.get(position);

        //holder.image1.setImageResource(people1.getImage());
        Glide.with(context).load(people1.getImage()).into(holder.image1);
        Glide.with(context).load(people1.getImage_status()).into(holder.image_status);
        holder.name1.setText(people1.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(context, people1.getName(), Toast.LENGTH_LONG).show();
                //context.startActivity(new Intent(context, Button_Sheets_dialog.class));
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetDialogTheme);
                View botton = LayoutInflater.from(context).inflate(R.layout.item_sheets_dialog, (LinearLayout) view.findViewById(R.id.bottonSheets));

                  RoundedImageView itemImage, imageStatus;
                  TextView itemName;
                  TextView itemCity;
                  TextView itemAge;

                itemCity = botton.findViewById(R.id.item_city);
                itemAge = botton.findViewById(R.id.item_age);

                itemImage = botton.findViewById(R.id.item_image);
                itemName = botton.findViewById(R.id.item_name);
                imageStatus = botton.findViewById(R.id.image_status);

                itemAge.setText(String.valueOf(people1.getAge()));
                itemCity.setText(people1.getAdress());
                itemName.setText(people1.getName());
                //itemImage.setImageResource(people1.getImage());

                Glide.with(context).load(people1.getImage()).into(itemImage);


                bottomSheetDialog.setContentView(botton);
                bottomSheetDialog.show();
            }
        }); }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
