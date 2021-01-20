package com.example.datting.Users;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.datting.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Information_Activity extends AppCompatActivity {

    ImageView cancel;
    TextView user_name, user_age, user_sex;
    String user_name1, user_age1, user_sex1;
    LinearLayout chieucao, cannang, ruoubia, hutthuoc, ngonngu;
    RelativeLayout info;
    TextView cong_viec, hoc_van, ve_ban, height_txt, weight_txt, bottom_sheets;
    int check_height, check_working, check_about, check_weight, check_user;
    String height, weight;
    RoundedImageView image1, image2, image3, image4, image5, image6;
    private String selectedImagePath;
    Uri selectedImageUri;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        anhxa();
        quaylai();
        Activity_Intent();
        Cong_Viec();
        About_Me();
        setHeight_txt();
        setWeight_txt();
        bottom_sheets();
        select_image();
        xuly_info();


    }
    private void  xuly_info()
    {
        Intent intent = getIntent();
        check_user = intent.getIntExtra("check_user", 0);
        user_name1 = intent.getStringExtra("user_name");
        user_age1 = intent.getStringExtra("user_age");
        user_sex1 = intent.getStringExtra("user_sex");
        if (check_user == 1) {
            user_name.setText(user_name1);
            user_age.setText(user_age1);
            user_sex.setText(user_sex1);
        }
        if (check_user == 0) {
            user_name.setText("Hieu Thanhhh");
            user_age.setText("20");
            user_sex.setText("Nam");
        }
    }

    private void select_image() {
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select(1);
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select(2);
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select(3);
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select(4);
            }
        });
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select(5);
            }
        });
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select(6);
            }
        });

    }

    public void select(int SELECT_PICTURE) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        bitmap_image(1, image1, requestCode, resultCode, data);
        bitmap_image(2, image2, requestCode, resultCode, data);
        bitmap_image(3, image3, requestCode, resultCode, data);
        bitmap_image(4, image4, requestCode, resultCode, data);
        bitmap_image(5, image5, requestCode, resultCode, data);
        bitmap_image(6, image6, requestCode, resultCode, data);
    }

    private void bitmap_image(int SELECT_PICTURE, RoundedImageView image,int requestCode,int resultCode,  Intent data) {
        if (resultCode == RESULT_OK && requestCode == SELECT_PICTURE) {
            selectedImageUri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri);
                image.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void bottom_sheets() {
        bottom_sheets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheets_Dialog b = new BottomSheets_Dialog(bottom_sheets);
                b.show(getSupportFragmentManager(), "Bottom_sheets");
                bottom_sheets.setTextColor(Color.parseColor("#747474"));
            }
        });
    }

    private void setWeight_txt() {
        Intent intent = getIntent();
        check_weight = intent.getIntExtra("check_weight", 0);
        weight = intent.getStringExtra("weight");
        if (check_weight == 1) {
            weight_txt.setText(weight + " kg");
        }
        if (check_weight == 0) {
            weight_txt.setText("60 kg");
        }
    }

    private void setHeight_txt() {
        Intent intent = getIntent();
        check_height = intent.getIntExtra("check_height", 0);
        height = intent.getStringExtra("height");
        if (check_height == 1) {
            height_txt.setText(height + " cm");
        }
        if (check_height == 0) {
            height_txt.setText("180 cm");
        }
    }

    private void Cong_Viec() {

        Intent intent = getIntent();
        check_working = intent.getIntExtra("check_working", 0);
        if (check_working == 1) {

            cong_viec.setText(intent.getStringExtra("congviec"));
            cong_viec.setTextColor(Color.parseColor("#747474"));

            hoc_van.setText(intent.getStringExtra("congty"));
            hoc_van.setTextColor(Color.parseColor("#747474"));
        }
        if (check_working == 0) {
            cong_viec.setText(" Thêm ");
            hoc_van.setText(" ");
        }
    }

    private void About_Me() {
        Intent intent = getIntent();
        check_about = intent.getIntExtra("check_about", 0);
        if (check_about == 1) {

            ve_ban.setText(intent.getStringExtra("about_me"));
            ve_ban.setTextColor(Color.parseColor("#747474"));

        }
        if (check_about == 0) {
            ve_ban.setText("Giới thiệu thông tin về bạn.");
        }
    }

    private void Activity_Intent() {

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Information_Activity.this, User_Activity.class));
            }
        });
        cong_viec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Information_Activity.this, Working_Activity.class));
            }
        });
        ve_ban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Information_Activity.this, AboutMe_Activity.class));
            }
        });
        chieucao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Information_Activity.this, Height_Activity.class));
            }
        });
        cannang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Information_Activity.this, Weight_Activity.class));
            }
        });
        hutthuoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Information_Activity.this, Alcohol_Activity.class));
            }
        });
        ngonngu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Information_Activity.this, Language_Activity.class));
            }
        });
        ruoubia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Information_Activity.this, Smoking_Activity.class));
            }
        });


    }

    private void anhxa() {

        //info
        user_name = findViewById(R.id.user_name);
        user_age = findViewById(R.id.user_age);
        user_sex = findViewById(R.id.user_sex);

        //UPload image
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);

        // toi o day de lam gi
        bottom_sheets = findViewById(R.id.bottom_sheet_user);
        // activity can nang va chieu cao
        height_txt = findViewById(R.id.height_txt);
        weight_txt = findViewById(R.id.weight_txt);

        cong_viec = findViewById(R.id.cong_viec);
        hoc_van = findViewById(R.id.hoc_van);
        ve_ban = findViewById(R.id.ve_ban);

        chieucao = findViewById(R.id.chieucao);
        cannang = findViewById(R.id.cannang);
        ruoubia = findViewById(R.id.ruoubia);
        hutthuoc = findViewById(R.id.hutthuoc);
        ngonngu = findViewById(R.id.ngonngu);

        //congviec_hocvan = findViewById(R.id.cong_viec);
        info = findViewById(R.id.sum_infor);
        cancel = findViewById(R.id.cancel);
    }

    private void quaylai() {
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
