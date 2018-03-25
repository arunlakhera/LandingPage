package com.example.android.landingpage;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import me.itangqi.waveloadingview.WaveLoadingView;

public class MainActivity extends AppCompatActivity {

    WaveLoadingView waveLoadingView;
    SeekBar seekBar;

    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        waveLoadingView = findViewById(R.id.waveloadingview);

        waveLoadingView.setProgressValue(0);


        waveDelay(10,2000);
        waveDelay(30,3000);
        waveDelay(70,4000);

        waveLoadingView.setCenterTitle(" Your BLOOD...");

        waveDelay(100,5000);

    }

    public void waveDelay( final int progressValue, int delayTimeValue) {

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms

                waveLoadingView.setProgressValue(progressValue);

            }
        }, delayTimeValue);
    }


    public void googlePlayClicked(View view) {

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=com.bison.d2d1"));
        startActivity(intent);
    }

    public void applePlayClicked(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://itunes.apple.com/in/app/donor2donor/id1081832897?mt=8"));
        startActivity(intent);

    }


}
