package com.example.teamproject.game01_shake;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teamproject.MainActivity;
import com.example.teamproject.R;

import java.sql.Time;

public class ShakeGameActivity extends AppCompatActivity implements SensorEventListener {

    public static Handler handler2 = new Handler(); // 핸들러

    public static Activity shakegame;

    private SensorManager sensorManager;
    private Sensor senAccelerometer;

    private long lastUpdate = 0;
    private float last_x, last_y, last_z;
    private static final int SHAKE_THRESHOLD = 600;

    private TextView tvSensorStatus;
    public static int count;

    private SoundPool soundPool;
    private int sound;

    TextView shakeTime;
    CountDownTimer shakeTimer;

    private int millisToTime(long millis){
        return (int) millis/1000;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_01shakegame_layout);

        shakegame = ShakeGameActivity.this; // 다른 액티비티 종료 2, 액티비티의 정보를 저장, 다음은 다른 액티비티에 가서 작성(현재는 ScoreInput에 있음)

//        new Handler().postDelayed(new Runnable() { // 스코어 점수 나오고 끝남
//            @Override
//            public void run() {
//                Intent intent = new Intent(ShakeGameActivity.this, ShakeGameActivity2.class);
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

        tvSensorStatus = (TextView) findViewById(R.id.tv_status);
        tvSensorStatus.setText(count+"");

        sensorManager = (SensorManager) this.getSystemService(SENSOR_SERVICE);
        senAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        shakeTime = findViewById(R.id.shakeTimer);
        shakeTime.setText("Time: " + millisToTime(10000));

        shakeTimer = new CountDownTimer(10000, 100){
            @Override
            public void onTick(long millisUntilFinished){
                shakeTime.setText("Time: " + millisToTime(millisUntilFinished));
            }
            @Override
            public void onFinish(){
                shakeTime.setText("Time: " + millisToTime(0));
                endGame();
            }
        };
        startGame();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor mySensor = sensorEvent.sensor;
        if(mySensor.getType() == Sensor.TYPE_ACCELEROMETER){
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            long curTime = System.currentTimeMillis(); // 현재시간
            if((curTime - lastUpdate) > 100) {
                long diffTime = (curTime - lastUpdate);
                lastUpdate = curTime;

                float speed = Math.abs(x + y + z - last_x - last_y - last_z) / diffTime * 10000;
                if (speed > SHAKE_THRESHOLD) {
                    //지정된 수치이상 흔들림이 있으면 실행
                    soundPool.play(sound, 1, 1, 0, 0, 1);
                    count++;
                    tvSensorStatus.setText(count+"");
                }

                //갱신
                last_x = x;
                last_y = y;
                last_z = z;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    private void startGame(){
        count = 0;
        tvSensorStatus.setText("Score: " + count);
        shakeTimer.start();
    }

    private void endGame(){
        shakeTimer.cancel();
        openActivity();
    }

    public void openActivity(){

        finish();
        Intent intent = new Intent(ShakeGameActivity.this, ShakeGameActivity2.class);
        intent.putExtra("score", count);
        startActivity(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onBackPressed() {

        shakeTimer.cancel();
        Intent i = new Intent(this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);

    }
}