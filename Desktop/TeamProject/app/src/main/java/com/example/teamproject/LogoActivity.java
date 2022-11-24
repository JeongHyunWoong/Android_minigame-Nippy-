package com.example.teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class LogoActivity extends AppCompatActivity {

    ImageView gameboy;
    Button btnStart;
    Animation start_blink;
    TextView tvTitle;
    public MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        gameboy = (ImageView) findViewById(R.id.gameboy);
        start_blink = AnimationUtils.loadAnimation(LogoActivity.this, R.anim.start_blink);

        findViewById(R.id.btnStart).setOnClickListener(mClick);
        btnStart = findViewById(R.id.btnStart);
        tvTitle = findViewById(R.id.tvTitle);
        btnStart.startAnimation(start_blink);

        Glide.with(LogoActivity.this).load(R.drawable.gameboy).into(gameboy);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        mp= MediaPlayer.create(this,R.raw.logobg);
        mp.start();

        findViewById(R.id.btnStart).setOnClickListener(mClick);
    }

    protected void onStart()
    {
        super.onStart();

        Animation animTreanTop = AnimationUtils.loadAnimation(getApplication(), R.anim.top_animation);
        tvTitle.startAnimation(animTreanTop);
    }

    Button.OnClickListener mClick = new Button.OnClickListener()

    {
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.btnStart:
                    Intent ex1 = new Intent(LogoActivity.this, MainActivity.class);
                    startActivity(ex1);
                    mp.stop();
                    finish();
                    break;
            }
        }
    };
}