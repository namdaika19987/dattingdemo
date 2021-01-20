package com.example.datting.Users;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.datting.R;

public class Working_Activity extends AppCompatActivity {
    ImageView cancel;
    TextView congty_text, congviec_text, save;
    EditText congty_edit, congviec_edit;
    String congty, congviec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working);
        anhxa();
        setCancel();
        xuly();
        setOnclick_name();

    }

    private void xuly() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                congty = congty_edit.getText().toString();
                congviec = congviec_edit.getText().toString();

                Intent intent = new Intent(Working_Activity.this, Information_Activity.class);
                intent.putExtra("check_working", 1);
                intent.putExtra("congty", congty);
                intent.putExtra("congviec", congviec);
                startActivity(intent);

            }
        });
    }

    private void setOnclick_name() {
        congty_edit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    congty_text.setTextColor(Color.parseColor("#ff78bb"));
                } else {
                    congty_text.setTextColor(Color.parseColor("#d0d0d0"));
                }
            }
        });

        congviec_edit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    congviec_text.setTextColor(Color.parseColor("#ff78bb"));
                } else {
                    congviec_text.setTextColor(Color.parseColor("#d0d0d0"));
                }

            }
        });

    }

    private void anhxa() {
        save = findViewById(R.id.save);
        congty_text = findViewById(R.id.tencongty_text);
        congviec_text = findViewById(R.id.nghenghiep_text);
        congty_edit = findViewById(R.id.tencongty_edit);
        congviec_edit = findViewById(R.id.nghenghiep_edit);

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
