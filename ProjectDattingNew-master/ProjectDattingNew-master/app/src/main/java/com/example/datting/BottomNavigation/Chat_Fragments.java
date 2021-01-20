package com.example.datting.BottomNavigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datting.Chat.AdapterChat.AdapterChat;
import com.example.datting.Chat.AdapterChat.AdapterStatus;
import com.example.datting.Chat.MessageActivity;
import com.example.datting.Model.PeopleClass;
import com.example.datting.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Chat_Fragments extends Fragment {
    CircleImageView circleImageView;
    LinearLayoutManager linearLayoutManager;
    RecyclerView view_status, view_mess;
    ArrayList<PeopleClass> people_status;
    ArrayList<PeopleClass> people_mess;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.chat_fragments, container, false);


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view_mess = view.findViewById(R.id.listchat);
        view_status = view.findViewById(R.id.listOnline);

        data_status();
        data_mess();
        recycView_status();
        recycView_mess();


    }
        // do du lieu
    private void data_mess() {
        people_mess = new ArrayList<>();
        people_mess.add(new PeopleClass("Hiếu Thành", R.drawable.thanhh, true, "HIếu Thành anh đây", "16 phút", 4));
        people_mess.add(new PeopleClass("Trường", R.drawable.nhunglon, true, "HIếu Thành pro", "16 phút", 6));
        people_mess.add(new PeopleClass("Hiếu Thành", R.drawable.thanhne, false, "HIếu Thành anh đây", "16 phút", 4));
        people_mess.add(new PeopleClass("Thành", R.drawable.ngoctrinh, false, "HIếu Thành pro", "20/7/2020", 0));
        people_mess.add(new PeopleClass("Hiếu Thành", R.drawable.ngoctrinh, true, "HIếu Thành anh đây", "02/02/2020", 0));
        people_mess.add(new PeopleClass("Kiên", R.drawable.ngoctrinh, true, "HIếu Thành pro", "22/5/2020", 2));
    }
        private void recycView_mess ()
        {
            linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
            AdapterChat adapterMess = new AdapterChat(people_mess, this.getContext());
            view_mess.setAdapter(adapterMess);
            view_mess.setLayoutManager(linearLayoutManager);

        }
        private void data_status ()
        {
            people_status = new ArrayList<>();
            people_status.add(new PeopleClass("Hiếu Thành", R.drawable.jisoo01));
            people_status.add(new PeopleClass("Hạ Anh", R.drawable.ngoctrinh));
            people_status.add(new PeopleClass("Hồng Nhung", R.drawable.thanhne));
            people_status.add(new PeopleClass("Ngữ Yên", R.drawable.jisso));
            people_status.add(new PeopleClass("Lee Nguyễn", R.drawable.thanhh));
            people_status.add(new PeopleClass("Hương Phạm", R.drawable.nhunglon));
        }
        private void recycView_status ()
        {

            linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
            AdapterStatus adapterChat = new AdapterStatus(people_status, getContext());
            view_status.setAdapter(adapterChat);
            view_status.setLayoutManager(linearLayoutManager);
        }
    }
