package com.example.datting.Meet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.example.datting.R;

import io.apptik.widget.MultiSlider;

public class ChonlocActivity extends AppCompatActivity {

    MultiSlider multiSlider5, multiSlider1;
    TextView khoangcach;
    int max = 0, min = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chonloc);

        final TextView age_Min = (TextView) findViewById(R.id.textMin1);
        final TextView age_Max = (TextView) findViewById(R.id.textMax1);



        khoangcach= findViewById(R.id.khoangcach);


        multiSlider5 = findViewById(R.id.age_slider);
        multiSlider1 = findViewById(R.id.rangeSeekbar_khoangcach);

        multiSlider5.setMax(200);
        multiSlider5.setMin(100);
        multiSlider5.setOnThumbValueChangeListener(new MultiSlider.OnThumbValueChangeListener() {
            @Override
            public void onValueChanged(MultiSlider multiSlider,
                                       MultiSlider.Thumb thumb,
                                       int thumbIndex,
                                       int value)
            {
                if (thumbIndex == 0) {
                    age_Min.setText(String.valueOf(value));
                } else {

                    age_Max.setText(String.valueOf(value));
                }
            }
        });

        multiSlider1.setMax(2000);
        multiSlider1.setMin(0);
        multiSlider1.setOnThumbValueChangeListener(new MultiSlider.OnThumbValueChangeListener() {
            @Override
            public void onValueChanged(MultiSlider multiSlider,
                                       MultiSlider.Thumb thumb,
                                       int thumbIndex,
                                       int value)
            {

                if (thumbIndex == 0) {
                     min= value;
                } else {
                     max = value;
                }
//                Toast.makeText(ChonlocActivity.this, max+"", Toast.LENGTH_SHORT).show();
//                Toast.makeText(ChonlocActivity.this, min+"", Toast.LENGTH_SHORT).show();
                khoangcach.setText(String.valueOf(max - min));
        }
        });





    }
}
