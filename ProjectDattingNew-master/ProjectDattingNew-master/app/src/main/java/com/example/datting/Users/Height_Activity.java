package com.example.datting.Users;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datting.R;
import com.makeramen.roundedimageview.RoundedImageView;

public class Height_Activity extends AppCompatActivity {
    RoundedImageView exit, save_height;
    TextView height_text;
    SeekBar seekBar_height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height_);

        anhxa();
        exit();
        xuly();
        xuly_save();
    }
    private void xuly_save()
    {
        save_height.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Height_Activity.this, Information_Activity.class);
                intent.putExtra("height",  seekBar_height.getProgress()+"");
                intent.putExtra("check_height", 1);
                startActivity(intent);

              //  Toast.makeText(Height_Activity.this, seekBar_height.getProgress()+" ", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void xuly()
    {
        seekBar_height.setMax(200);
        seekBar_height.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                height_text.setText(seekBar_height.getProgress()+ "cm");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    private void anhxa() {

        height_text = findViewById(R.id.chieucao_text);
        seekBar_height = findViewById(R.id.rangeSeekbar_height);
        exit = findViewById(R.id.exit);
        save_height = findViewById(R.id.save_height);
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
