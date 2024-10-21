package com.example.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.fagment.HomeFragment;

public class AmazonMainActivity extends AppCompatActivity {
    private ImageView icHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amazon_main);

        initView();
    }

    private void initView() {
        icHome = findViewById(R.id.ic_home);

        HomeFragment homeFragment = new HomeFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fl_container, homeFragment);
        fragmentTransaction.commit();


        // Set click listener for icHome
        icHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create MediaPlayer for click sound effect
                MediaPlayer mediaPlayer = MediaPlayer.create(AmazonMainActivity.this, R.raw.click_effect_music);
                mediaPlayer.start();

                // Check if HomeFragment is already added
                if (!homeFragment.isAdded()) {
                    // If not added, replace current fragment with HomeFragment
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fl_container, homeFragment)
                            .addToBackStack(null)  // Optional: Add to back stack
                            .commit();
                }
            }
        });


//        icHome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                MediaPlayer mediaPlayer = MediaPlayer.create(AmazonMainActivity.this, R.raw.click_effect_music);
//                mediaPlayer.start();
//
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.fl_container,homeFragment);
//                fragmentTransaction.commit();
//
//            }
//        });


    }

}