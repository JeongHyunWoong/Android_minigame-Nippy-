package com.example.teamproject.game08_mole;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teamproject.MainActivity;
import com.example.teamproject.R;

import java.util.Random;
import java.util.Timer;

public class MoleMainActivity1 extends AppCompatActivity {

    public static Handler handler2 = new Handler(); // 핸들러

    public static Activity molegame;

    Thread thread = null;
    TextView time;
    TextView score;
    ImageView[] imgViewArr = new ImageView[16];
    int[] imageId = {R.id.hole01, R.id.hole02, R.id.hole03, R.id.hole04, R.id.hole05, R.id.hole06, R.id.hole07, R.id.hole08, R.id.hole09, R.id.hole10, R.id.hole11, R.id.hole12, R.id.hole13, R.id.hole14, R.id.hole15, R.id.hole16};
    public static final int ran[] = {R.drawable.up_mole, R.drawable.up_mole1, R.drawable.up_bomb};

    public static int currentScore;

    final String TAG_Mole1 = "mole";
    final String TAG_Mole2 = "mole1";
    final String TAG_Rabbit = "rabbit";

    private SoundPool soundPool;
    private int sound1, sound2, sound3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_08main1);

        molegame = MoleMainActivity1.this; // 다른 액티비티 종료 2, 액티비티의 정보를 저장, 다음은 다른 액티비티에 가서 작성(현재는 ScoreInput에 있음)

//        new Handler().postDelayed(new Runnable() { // 스코어 점수 나오고 끝남
//            @Override
//            public void run() {
//                Intent intent = new Intent(MoleMainActivity1.this, MoleMainActivity2.class);
//                startActivity(intent); // 플레이 액티비티 시작
//            }
//        }, 10000);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            soundPool = new SoundPool.Builder().setMaxStreams(10).build();
        }
        else{
            soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        }
        sound1 = soundPool.load(this, R.raw.mole1,1);
        sound2 = soundPool.load(this, R.raw.mole1,1);
        sound3 = soundPool.load(this, R.raw.bomb,1);

        time = findViewById(R.id.time);
        score = findViewById(R.id.score);

        for (int i = 0; i < imgViewArr.length; i++) {
            imgViewArr[i] = (ImageView) findViewById(imageId[i]);
            imgViewArr[i].setImageResource(R.drawable.off);

            imgViewArr[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (((ImageView) v).getTag().toString().equals(TAG_Mole1)) {
                        score.setText("Point : "+String.valueOf(currentScore += 200));
                        ((ImageView) v).setImageResource(R.drawable.off);
                        soundPool.play(sound1, 1, 1, 0, 0, 1);

                    } else if (((ImageView) v).getTag().toString().equals(TAG_Mole2)) {
                        score.setText("Point : "+String.valueOf(currentScore += 100));
                        ((ImageView) v).setImageResource(R.drawable.off);
                        soundPool.play(sound2, 1, 1, 0, 0, 1);

                    } else {
                        score.setText("Point : "+String.valueOf(currentScore -= 200));
                        ((ImageView) v).setImageResource(R.drawable.off);
                        soundPool.play(sound3, 1, 1, 0, 0, 1);
                    }
                }
            });
        }
        time.setText("Time : 20");
        score.setText("Point : 0");

        new Thread(new timer()).start();
        for (int i = 0; i < imgViewArr.length; i++) {
            new Thread(new objectThread(i)).start();
        }
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {

            time.setText("Time : "+ msg.arg1);
        }
    };

    Handler onHandler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            for (int i=0;i<5;i++){
                int index = (int) (Math.random() * 3);
                imgViewArr[msg.arg1].setImageResource(ran[index]);
                if(index==0){
                    imgViewArr[msg.arg1].setTag(TAG_Mole1);
                }
                else if(index==1){
                    imgViewArr[msg.arg1].setTag(TAG_Mole2);
                }
                else{
                    imgViewArr[msg.arg1].setTag(TAG_Rabbit);
                }
            }
        }
    };

    Handler offHandler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            imgViewArr[msg.arg1].setImageResource(R.drawable.off);
        }
    };

    public class timer implements Runnable {

        final int TIME = 20;

        @Override
        public void run() {
            for (int i = TIME; i >= 0; i--) {
                Message msg = new Message();
                msg.arg1 = i;
                handler.sendMessage(msg);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Intent intent = new Intent(MoleMainActivity1.this, MoleMainActivity2.class);
            intent.putExtra("score", currentScore);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {

        finish();
        Intent i = new Intent(this, MoleMainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }

    public class objectThread implements Runnable{

        int index;

        objectThread(int index){
            this.index=index;
        }

        @Override
        public void run() {
            while(true){
                try {
                    Message msg1 = new Message();
                    int offtime = new Random().nextInt(6000) + 1000;
                    Thread.sleep(offtime); //두더지가 내려가있는 시간

                    msg1.arg1 = index;
                    onHandler.sendMessage(msg1);

                    int ontime = new Random().nextInt(3000)+ 500;
                    Thread.sleep(ontime); //두더지가 올라가있는 시간
                    Message msg2 = new Message();
                    msg2.arg1= index;
                    offHandler.sendMessage(msg2);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}