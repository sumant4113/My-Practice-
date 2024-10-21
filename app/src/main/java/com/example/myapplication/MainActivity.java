package com.example.myapplication;

import static android.content.Intent.CATEGORY_APP_CALENDAR;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    private ImageView imgPlay, imgStop;
    private Button btnClick, btnIntent, btnRtoApi;
    private TextView txtMusic;
    public static final String uri = CATEGORY_APP_CALENDAR;
    private static final int pic_id = 123;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        txtMusic = findViewById(R.id.txt_music);
        imgPlay = findViewById(R.id.img_play);
        imgStop = findViewById(R.id.img_stop);
        btnClick = findViewById(R.id.btn_click);
        btnIntent = findViewById(R.id.btn_intent);
        btnRtoApi = findViewById(R.id.btn_rtoApi);

// Declaring the animation view
        LottieAnimationView animationView
                = findViewById(R.id.animation_view);
        animationView
                .addAnimatorUpdateListener(
                        (animation) -> {
                            // Do something.
                        });
        animationView
                .playAnimation();

        if (animationView.isAnimating()) {
            // Do something.
        }

        btnRtoApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RtoApiActivity.class);
                startActivity(intent);
            }
        });
        btnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                intent.setData(Uri.parse());
                startActivityForResult(intent, pic_id);


            }
        });

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.click_effect_music);
                mediaPlayer.start();

                Intent intent = new Intent(MainActivity.this, ApiActivity.class);
                startActivity(intent);

            }
        });

        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.click_effect_music);
                mediaPlayer.start();

                Intent intent = new Intent(MainActivity.this, AmazonMainActivity.class);
                startActivity(intent);
            }
        });
        imgStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.click_effect_music);
                mediaPlayer.start();

                Intent intent = new Intent(MainActivity.this, AmazonMainActivity.class);
                startActivity(intent);
            }
        });


    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Match the request 'pic id with requestCode
        if (requestCode == pic_id) {
            // BitMap is data structure of image file which store the image in memory
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            // Set the image in imageview for display
            imgPlay.setImageBitmap(photo);
        }
    }


}