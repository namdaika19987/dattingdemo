package com.example.datting.BottomNavigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.datting.R;
import com.example.datting.Users.Information_Activity;
import com.example.datting.Users.Setting_Fragments;
import com.example.datting.Users.User_Activity;

public class User_Fragments extends Fragment {

    ImageView setting, image_hoso;
    TextView information, user_hoso;
    ImageView abc;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_fragments, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        anhxa(view);
        edit_user();

       // Intent intent =



        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getContext(), Setting_Fragments.class);
//                startActivity(intent);
                Setting_Fragments setting_fragments = new Setting_Fragments();
                //setting_fragments.setA(1);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, setting_fragments).commit();
            }
        });

        image_hoso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Information_Activity.class);
                startActivity(intent);
            }
        });
    }
        private void edit_user()
    {
       user_hoso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext() , User_Activity.class));
            }
        });
    }
    private void anhxa(View view)
    {
        image_hoso = view.findViewById(R.id.image_hoso);
        user_hoso = view.findViewById(R.id.user_hoso);
        setting = view.findViewById(R.id.settings);
        information = view.findViewById(R.id.information);
    }
}
