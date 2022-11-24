package com.example.teamproject.game05_stop;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teamproject.R;

public class StopMainActivity2 extends AppCompatActivity {

    Button btnClick;
    TextView tv_countdowntimer;

    CountDownTimer countDownTimer;
    float countdowntimerValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_05main2);

        btnClick = findViewById(R.id.btnClick);
        tv_countdowntimer = findViewById(R.id.tv_countdowntimer);

        findViewById(R.id.btnClick).setOnClickListener(mClick);

        countdowntimerValue = 100;
        countDownTimer = new CountDownTimer(10000, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                tv_countdowntimer.setText(String.format("%.3f", 10-millisUntilFinished / 1000.));
            }
            @Override
            public void onFinish() {
                tv_countdowntimer.setText("완료");
            }
        };
        countDownTimer.start();
    }

    Button.OnClickListener mClick = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnClick:
                    if(countDownTimer != null) {countDownTimer.cancel();}
                    break;
            }
        }
    };
}
