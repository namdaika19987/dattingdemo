package com.example.datting.Meet;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.datting.Home.Home.People;
import com.example.datting.Model.Meet;
import com.example.datting.R;
import com.squareup.picasso.Picasso;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.util.ArrayList;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MeetAdapter extends RecyclerView.Adapter<MeetAdapter.ViewHolder> {
    private ArrayList<Meet> meets;
    Context context;
    boolean check = true;
    CardStackLayoutManager manager;
    private int dem = 1;

    public ArrayList<Meet> getMeets() {
        return meets;
    }

    public void setMeets(ArrayList<Meet> meets) {
        this.meets = meets;
    }


    public MeetAdapter(ArrayList<Meet> meets, Context context, CardStackLayoutManager manager) {
        this.meets = meets;
        this.context = context;
        this.manager = manager;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Meet meet = meets.get(position);

        holder.setData(meets.get(position));
        holder.linearLayout_infor.setVisibility(View.GONE);
        holder.status_infor.setVisibility(VISIBLE);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.status_infor.setVisibility(View.GONE);
                holder.linearLayout.setVisibility(View.GONE);
                holder.linearLayout_infor.setVisibility(VISIBLE);

                if (check) {
                    holder.setSizeScreen(holder.image_tinder);
                    check = false;
                }

                holder.xo_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (dem % 2 == 1) {

                            holder.xo_layout.setImageResource(R.drawable.dow_metting);
                            manager.setSwipeableMethod(SwipeableMethod.None);
                            holder.about_me.setVisibility(View.VISIBLE);
                            holder.status_infor.setVisibility(VISIBLE);

                        } else {
                            holder.status_infor.setVisibility(View.GONE);
                            holder.xo_layout.setImageResource(R.drawable.ic_share);
                            //manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual);
                            holder.about_me.setVisibility(View.GONE);
                            holder.linearLayout.setVisibility(View.GONE);
                            holder.linearLayout_infor.setVisibility(View.VISIBLE);

                            if (holder.about_me.getVisibility() == View.GONE) {
                                holder.image.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        holder.linearLayout_infor.setVisibility(View.GONE);

                                        if (check == false) {
                                            holder.getSizeScreen(holder.image_tinder);
                                            check = true;

                                            manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual);
                                            holder.linearLayout.setVisibility(VISIBLE);
                                            holder.status_infor.setVisibility(View.VISIBLE);
                                        }
                                    }
                                });
                            }
                        }                dem++;
                    }
                });
                manager.setStackFrom(StackFrom.None);
                manager.setScaleInterval(0.4f);
                manager.setSwipeThreshold(0.3f);
                manager.setMaxDegree(20.0f);
                manager.setDirections(Direction.HORIZONTAL);
                manager.setCanScrollHorizontal(true);
                manager.setSwipeableMethod(SwipeableMethod.None);
                manager.setOverlayInterpolator(new LinearInterpolator());

            }

        });
    }

    @Override
    public int getItemCount() {
        return meets.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        ImageView image, xo_layout;
        TextView nama, usia, kota;
        CardView cardView;
        LinearLayout linearLayout, linear_tong;
        LinearLayout linearLayout_infor, status_infor;
        RelativeLayout image_tinder, about_me;
        ScrollView scrollView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.item_image);
            nama = itemView.findViewById(R.id.item_name);
            usia = itemView.findViewById(R.id.item_age);
            kota = itemView.findViewById(R.id.item_city);
            linearLayout = itemView.findViewById(R.id.infor);
            cardView = itemView.findViewById(R.id.cardview);
            status_infor = itemView.findViewById(R.id.status_tinder);
            linearLayout_infor = itemView.findViewById(R.id.infor_user);
            image_tinder = itemView.findViewById(R.id.image_tinder);
            xo_layout = itemView.findViewById(R.id.xo_layout);
            scrollView = itemView.findViewById(R.id.scrollview);
            linear_tong = itemView.findViewById(R.id.linearlayout_tong);
            about_me = itemView.findViewById(R.id.about_me);
        }

        public void setData(Meet meet) {

            Glide.with(context).load(meet.getImage()).into(image);
            nama.setText(meet.getName());
            usia.setText(meet.getAge());
            kota.setText(meet.getAdress());
        }


        public void setSizeScreen(RelativeLayout layout) {


            DisplayMetrics displaymetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
//            //if you need three fix imageview in width
//            int devicewidth = displaymetrics.widthPixels;
            //if you need 4-5-6 anything fix imageview in height
            int deviceheight = (displaymetrics.heightPixels) - (displaymetrics.heightPixels) /3 + 20;
            // layout.getLayoutParams().width = devicewidth;
            //if you need same height as width you can set devicewidth in holder.image_view.getLayoutParams().height
            layout.getLayoutParams().height = deviceheight;
        }

        public void getSizeScreen(RelativeLayout layout) {


            DisplayMetrics displaymetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
//            //if you need three fix imageview in width
//            int devicewidth = displaymetrics.widthPixels;
            //if you need 4-5-6 anything fix imageview in height
            int deviceheight = (displaymetrics.heightPixels) + (displaymetrics.heightPixels) / 3 + 20;
            // layout.getLayoutParams().width = devicewidth;
            //if you need same height as width you can set devicewidth in holder.image_view.getLayoutParams().height
            layout.getLayoutParams().height = deviceheight;
        }


    }

}
