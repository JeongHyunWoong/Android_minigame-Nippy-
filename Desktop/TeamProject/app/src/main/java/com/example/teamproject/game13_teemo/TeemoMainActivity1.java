package com.example.teamproject.game13_teemo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.teamproject.R;
import com.example.teamproject.game07_piano.PianoMainActivity1;

import java.util.Random;

public class TeemoMainActivity1 extends AppCompatActivity {

    public static Handler handler2 = new Handler(); // 핸들러

    public static Activity teemogame;

    TextView twTime;
    TextView twScore;
    ImageView teemo;
    public static int scoreNumb;
    Handler handler;
    Runnable runnable;

    CountDownTimer Timer;
    int setDelayMillis;
    private SoundPool soundPool;
    private int sound;

    private int millisToTime(long millis){
        return (int) millis/1000;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_13main1_teemo);

        twTime = findViewById(R.id.twTime);
        twScore = findViewById(R.id.twScore);
        teemo = findViewById(R.id.imageView);
        setDelayMillis = 0;

        teemogame = TeemoMainActivity1.this; // 다른 액티비티 종료 2, 액티비티의 정보를 저장, 다음은 다른 액티비티에 가서 작성(현재는 ScoreInput에 있음)

//        new Handler().postDelayed(new Runnable() { // 스코어 점수 나오고 끝남
//            @Override
//            public void run() {
//                Intent intent = new Intent(TeemoMainActivity1.this, TeemoMainActivity2.class);
//                startActivity(intent); // 플레이 액티비티 시작
//            }
//        }, 10000);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            soundPool = new SoundPool.Builder().setMaxStreams(10).build();
        }
        else{
            soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        }

        sound = soundPool.load(this, R.raw.teemo,1);

        teemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreNumb++;
                twScore.setText("Score: " + scoreNumb);
                soundPool.play(sound, 1, 1, 0, 0, 1);

            }
        });
        getDelayMilliseconds();
        putRandomlyScreen();
        countDownTimeLeft();
    }

    public void putRandomlyScreen() {

        {
            handler = new Handler();

            runnable = new Runnable() {
                @Override
                public void run() {

                    Random random = new Random();

                    int randomX = random.nextInt(800);
                    int randomY = random.nextInt(1500);

                    teemo.setX(randomX);
                    teemo.setY(randomY);

                    handler.postDelayed(runnable, setDelayMillis);
                }
            };
            handler.post(runnable);
        }
    }

    public void countDownTimeLeft() {

        Timer = new CountDownTimer(11000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                twTime.setText("Time: " + millisToTime(millisUntilFinished));
            }

            @Override
            public void onFinish() {

                twTime.setText("Time OFF"+millisToTime(0));

                handler.removeCallbacks(runnable);

                AlertDialog.Builder builder = new AlertDialog.Builder(TeemoMainActivity1.this);

                builder.setPositiveButton("", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        scoreNumb = 0;
                        twScore.setText("Score: " + scoreNumb);
                    }
                });openActivity3();
            }
        }.start();
    }

    public void getDelayMilliseconds() {

        Intent intent = getIntent();
        setDelayMillis = intent.getIntExtra("delayMillis", 0);
    }

    public void openActivity3(){

        Timer.cancel();
        Intent intent = new Intent(TeemoMainActivity1.this, TeemoMainActivity2.class);
        intent.putExtra("score", scoreNumb);
        startActivity(intent);
    }
}