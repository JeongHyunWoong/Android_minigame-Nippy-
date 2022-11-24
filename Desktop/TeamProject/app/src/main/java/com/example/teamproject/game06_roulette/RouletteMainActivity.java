package com.example.teamproject.game06_roulette;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teamproject.MainActivity;
import com.example.teamproject.R;

import java.util.Random;

public class RouletteMainActivity extends AppCompatActivity implements Animation.AnimationListener {

    boolean blnButtonRotation = true;
    int intNumber = 6;;
    long lngDegrees = 0;
    SharedPreferences sharedPreferences;

    private SoundPool soundPool;
    private int sound;

    ImageView selected,imageRoulette;

    Button start,up,down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(1024);
        requestWindowFeature(1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_06main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            soundPool = new SoundPool.Builder().setMaxStreams(10).build();
        }
        else{
            soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        }
        sound = soundPool.load(this, R.raw.roulettesound,1);

        start = (Button)findViewById(R.id.buttonStart);
        up = (Button)findViewById(R.id.buttonUp);
        down = (Button)findViewById(R.id.buttonDown);

        selected = (ImageView)findViewById(R.id.imageSelected);
        imageRoulette = (ImageView)findViewById(R.id.rouletteImage);

        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.intNumber = this.sharedPreferences.getInt("INT_NUMBER",6);
        setImageRoulette(this.intNumber);
    }

    @Override
    public void onAnimationStart(Animation animation)
    {
        this.blnButtonRotation = false;
        start.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Toast toast = Toast.makeText(this, " " + String.valueOf((int)(((double)this.intNumber)
                - Math.floor(((double)this.lngDegrees) / (360.0d / ((double)this.intNumber))))) + " ",0);
        toast.setGravity(49,0,0);
        toast.show();
        this.blnButtonRotation = true;
        start.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    public void onClickButtonRotation(View v)
    {
        if(this.blnButtonRotation)
        {
            int ran = new Random().nextInt(360) + 6000;
            RotateAnimation rotateAnimation = new RotateAnimation((float)this.lngDegrees, (float)
                    (this.lngDegrees + ((long)ran)),1,0.5f,1,0.5f);
            soundPool.play(sound, 1, 1, 0, 0, 1);

            this.lngDegrees = (this.lngDegrees + ((long)ran)) % 360;
            rotateAnimation.setDuration((long)ran);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setInterpolator(new DecelerateInterpolator());
            rotateAnimation.setAnimationListener(this);
            imageRoulette.setAnimation(rotateAnimation);
            imageRoulette.startAnimation(rotateAnimation);
        }
    }

    public void buttonUp(View v)
    {
        if(this.intNumber < 10)
        {
            this.intNumber++;
            setImageRoulette(this.intNumber);
            down.setVisibility(View.VISIBLE);
            SharedPreferences.Editor editor = this.sharedPreferences.edit();
            editor.putInt("INT_NUMBER",this.intNumber);
            editor.commit();
        }
        if(this.intNumber ==10)
        {
            up.setVisibility(View.VISIBLE);
        }
    }

    public void buttonDown(View v)
    {
        if(this.intNumber > 2)
        {
            this.intNumber--;
            setImageRoulette(this.intNumber);
            up.setVisibility(View.VISIBLE);

            SharedPreferences.Editor editor = this.sharedPreferences.edit();
            editor.putInt("INT_NUMBER",this.intNumber);
            editor.commit();

        }
        if(this.intNumber > 2)
        {
            down.setVisibility(View.VISIBLE);
        }
    }

    private void setImageRoulette(int myNumber)
    {
        switch(myNumber)
        {
            case 1:
                imageRoulette.setImageDrawable(getResources().getDrawable(R.drawable.roulette));
                return;
            case 2:
                imageRoulette.setImageDrawable(getResources().getDrawable(R.drawable.roulette_2));
                return;
            case 3:
                imageRoulette.setImageDrawable(getResources().getDrawable(R.drawable.roulette_3));
                return;
            case 4:
                imageRoulette.setImageDrawable(getResources().getDrawable(R.drawable.roulette_4));
                return;
            case 5:
                imageRoulette.setImageDrawable(getResources().getDrawable(R.drawable.roulette_5));
                return;
            case 6:
                imageRoulette.setImageDrawable(getResources().getDrawable(R.drawable.roulette_6));
                return;
            case 7:
                imageRoulette.setImageDrawable(getResources().getDrawable(R.drawable.roulette_7));
                return;
            case 8:
                imageRoulette.setImageDrawable(getResources().getDrawable(R.drawable.roulette_8));
                return;
            case 9:
                imageRoulette.setImageDrawable(getResources().getDrawable(R.drawable.roulette_9));
                return;
            case 10:
                imageRoulette.setImageDrawable(getResources().getDrawable(R.drawable.roulette_10));
                return;
        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}
