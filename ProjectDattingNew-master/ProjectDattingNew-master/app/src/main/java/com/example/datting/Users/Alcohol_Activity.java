package com.example.datting.Users;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.datting.R;
import com.makeramen.roundedimageview.RoundedImageView;

public class Alcohol_Activity extends AppCompatActivity {
    RoundedImageView exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcohol_);

        exit = findViewById(R.id.exit);
        exit();
    }
    private void exit() {
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
