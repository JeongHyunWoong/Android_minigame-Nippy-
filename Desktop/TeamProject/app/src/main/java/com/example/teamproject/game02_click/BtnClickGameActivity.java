package com.example.teamproject.game02_click;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teamproject.MainActivity;
import com.example.teamproject.MySQLiteOpenHelper_click;
import com.example.teamproject.R;

public class BtnClickGameActivity extends AppCompatActivity {

    public static Handler handler2 = new Handler(); // 핸들러

    public static Activity clickgame;

    private Button btnClick;
    private TextView tvCount;
    private int count = 0;
    public static int currentScore;

    private SoundPool soundPool;
    private int sound;

    TextView time;
    CountDownTimer timer;

    private int millisToTime(long millis){
        return (int) millis/1000;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_02btnclickgame_layout);

        clickgame = BtnClickGameActivity.this; // 다른 액티비티 종료 2, 액티비티의 정보를 저장, 다음은 다른 액티비티에 가서 작성(현재는 ScoreInput에 있음)

//        new Handler().postDelayed(new Runnable() { // 스코어 점수 나오고 끝남
//            @Override
//            public void run() {
//                Intent intent = new Intent(BtnClickGameActivity.this, BtnClickGameActivity2.class);
//                startActivity(intent); // 플레이 액티비티 시작
//            }
//        }, 10000);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            soundPool = new SoundPool.Builder().setMaxStreams(10).build();
        }
        else{
            soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        }
        sound = soundPool.load(this, R.raw.btnclick,1);

        tvCount = findViewById(R.id.tvCount);
        tvCount.setText(count+"");
        btnClick = findViewById(R.id.btnClick);
        time = findViewById(R.id.tvTime);
        time.setText("Time: " + millisToTime(10000));

        timer = new CountDownTimer(10000, 100){
            @Override
            public void onTick(long millisUntilFinished){
                time.setText("Time: " + millisToTime(millisUntilFinished));
            }
            @Override
            public void onFinish(){
                time.setText("Time: " + millisToTime(0));
                btnClick.setEnabled(false);
                endGame();
            }
        };

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                continueGame();
                soundPool.play(sound, 1, 1, 0, 0, 1);
            }
        });
        startGame();
    }

    private void startGame(){
        currentScore = 0;
        tvCount.setText("Score: " + currentScore);
        timer.start();
    }

    private void continueGame(){
        currentScore++;
        tvCount.setText("Score: " + currentScore);
    }

    private void endGame(){
        timer.cancel();
        openActivity();
    }

    public void openActivity(){

        finish();
        Intent intent = new Intent(BtnClickGameActivity.this, com.example.teamproject.game02_click.BtnClickGameActivity2.class);
        intent.putExtra("score", currentScore);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        timer.cancel();
        Intent i = new Intent(this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}

