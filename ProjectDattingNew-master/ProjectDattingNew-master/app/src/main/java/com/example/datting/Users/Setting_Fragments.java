package com.example.datting.Users;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.datting.BottomNavigation.User_Fragments;
import com.example.datting.R;

public class Setting_Fragments extends Fragment {
    ImageView cancel;
    int a;
    Context context;

    public void setA(int a) {
        this.a = a;
    }

    Fragment fragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_setting, container, false);
        context = view.getContext();
        fragment = this;
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toast.makeText(getContext(), "" + a, Toast.LENGTH_SHORT).show();
        cancel = view.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User_Fragments user_fragments = new User_Fragments();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, user_fragments)
                        .commit();


            }
        });
    }
}

