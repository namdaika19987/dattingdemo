package com.example.datting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.datting.BottomNavigation.Chat_Fragments;
import com.example.datting.BottomNavigation.Home_Fragments;
import com.example.datting.BottomNavigation.Meet_Fragments;
import com.example.datting.BottomNavigation.User_Fragments;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigation_Activity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navlisstner);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home_Fragments()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navlisstner = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment = null;
            switch (menuItem.getItemId()) {
                case R.id.nav_home:
                    fragment = new Home_Fragments();
                    break;
                case R.id.nav_meet:
                    fragment = new Meet_Fragments();
                    break;
                case R.id.nav_chat:
                    fragment = new Chat_Fragments();
                    break;
                case R.id.nav_user:
                    fragment = new User_Fragments();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        }

    };


}
