package com.example.datting.Users;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datting.R;

public class AboutMe_Activity extends AppCompatActivity {
    ImageView cancel;
    TextView save;
    EditText about_me_edit;
    String about_me;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me_);
        anhxa();
        setCancel();
        xuly();
    }

    private void xuly() {


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                about_me = about_me_edit.getText().toString();
                Intent intent = new Intent(AboutMe_Activity.this, Information_Activity.class);
                intent.putExtra("check_about", 1);
                intent.putExtra("about_me", about_me);
                startActivity(intent);
//                Toast.makeText(AboutMe_Activity.this, ""+about_me, Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void anhxa() {
        about_me_edit = findViewById(R.id.about_me_edit);
        save = findViewById(R.id.save);
        cancel = findViewById(R.id.cancel);
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
