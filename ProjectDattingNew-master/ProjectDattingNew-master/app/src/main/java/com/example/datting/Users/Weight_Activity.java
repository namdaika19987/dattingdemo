package com.example.datting.Users;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.datting.R;
import com.makeramen.roundedimageview.RoundedImageView;

public class Weight_Activity extends AppCompatActivity {
    RoundedImageView exit, save_weight;
    TextView weight_text;
    SeekBar seekBar_weight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_);

        anhxa();
        exit();
        xuly();
        xuly_save();
    }
    private void xuly_save()
    {
        save_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Weight_Activity.this, Information_Activity.class);
                intent.putExtra("weight",  seekBar_weight.getProgress()+"");
                intent.putExtra("check_weight", 1);
                startActivity(intent);

                //  Toast.makeText(Height_Activity.this, seekBar_height.getProgress()+" ", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void xuly()
    {
        seekBar_weight.setMax(200);
        seekBar_weight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                weight_text.setText(seekBar_weight.getProgress() + " kg");
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

        weight_text = findViewById(R.id.cangnang_text);
        seekBar_weight = findViewById(R.id.rangeSeekbar_weight);
        exit = findViewById(R.id.exit);
        save_weight = findViewById(R.id.save_weight);
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
