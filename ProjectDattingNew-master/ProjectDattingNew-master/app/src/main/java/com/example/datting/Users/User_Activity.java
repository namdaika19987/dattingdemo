package com.example.datting.Users;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datting.BottomNavigation.User_Fragments;
import com.example.datting.R;

public class User_Activity extends AppCompatActivity {
    ImageView cancel;
    TextView user_text, age_text;
    EditText user_edit, age_edit;
    TextView save_user;

    RadioGroup radioGroup;
    CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
    public String name, age, sex_text= "";;
    RadioButton sex_men, sex_girl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tai_khoan_);
        anhxa();
        //quay lai man user_fragment
        setOnclic_name();
        setCancel();
        xuly();
//        xuly_radio();


    }

    private void xuly() {
        save_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(sex_girl.isChecked())
                {
                    sex_text = sex_girl.getText().toString();
                   // Toast.makeText(User_Activity.this, sex_girl.getText(), Toast.LENGTH_SHORT).show();
                }
                if(sex_men.isChecked())
                {
                    sex_text = sex_men.getText().toString();
                    //Toast.makeText(User_Activity.this, sex_men.getText(), Toast.LENGTH_SHORT).show();
                }


                name = user_edit.getText().toString();
                age = age_edit.getText().toString();
                Intent intent = new Intent(User_Activity.this, Information_Activity.class);
               // Toast.makeText(User_Activity.this, sex_text, Toast.LENGTH_SHORT).show();
                intent.putExtra("user_name", name);
                intent.putExtra("user_age", age);
                intent.putExtra("user_sex", sex_text);
                intent.putExtra("check_user", 1);
                startActivity(intent);
            }
        });
    }

    private void setOnclic_name() {
        user_edit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    user_text.setTextColor(Color.parseColor("#ff78bb"));
                } else {
                    user_text.setTextColor(Color.parseColor("#d0d0d0"));
                }
            }
        });

        age_edit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    age_text.setTextColor(Color.parseColor("#ff78bb"));
                } else {
                    age_text.setTextColor(Color.parseColor("#d0d0d0"));
                }

            }
        });

    }


    private void anhxa() {


        radioGroup = findViewById(R.id.radio_group);
        sex_girl = findViewById(R.id.woman);
        sex_men = findViewById(R.id.man);


        save_user = findViewById(R.id.save_user);
        cancel = findViewById(R.id.cancel);
        user_text = findViewById(R.id.hoten);
        age_text = findViewById(R.id.ngaysinh_text);
        user_edit = findViewById(R.id.hoten_edit);
        age_edit = findViewById(R.id.ngaysinh_edit);
    }

    private void setCancel() {
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
