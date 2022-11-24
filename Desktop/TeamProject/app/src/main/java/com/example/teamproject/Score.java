package com.example.teamproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_wait);

    }
    // 뒤로 버튼을 눌러서 액티비티 종료
    @Override
    public void onBackPressed() {
        super.finish(); // 액티비티 종료
    }
}