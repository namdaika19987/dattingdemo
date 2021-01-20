package com.example.datting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private static final long RUN_TIME = 3000 ;
    Animation topAnim, botAnim;
    LinearLayout layout1, layout2;
    ImageView traitym, name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        traitym = findViewById(R.id.traitym);
        name = findViewById(R.id.name);

        Glide.with(this).load(R.drawable.icon_1).into(traitym);
        Glide.with(this).load(R.drawable.icon_3).into(name);

        animation();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,  BottomNavigation_Activity.class);
                startActivity(intent);finish();

            }
        }, RUN_TIME);
    }
    private void animation()
    {
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        botAnim = AnimationUtils.loadAnimation(this, R.anim.bot_animation);

        layout1 = findViewById(R.id.layout1);
        layout1.setAnimation(topAnim);


        layout2 = findViewById(R.id.layout2);
        layout2.setAnimation(botAnim);
    }

}
