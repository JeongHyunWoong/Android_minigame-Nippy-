package com.example.teamproject.game15_hanoi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teamproject.MainActivity;
import com.example.teamproject.R;
import com.example.teamproject.game08_mole.MoleMainActivity;

public class HanoiMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_15main);

        findViewById(R.id.btn1).setOnClickListener(mClick);
        findViewById(R.id.btn2).setOnClickListener(mClick);

    }
    Button.OnClickListener mClick = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn1:
                    Intent ex1 = new Intent(HanoiMainActivity.this, HanoiMainActivity1.class);
                    startActivity(ex1);
                    break;
                case R.id.btn2:
                    Intent ex2 = new Intent(HanoiMainActivity.this, HanoiMainActivity2.class);
                    startActivity(ex2);
                    break;
            }
        }
    };

    @Override
    public void onBackPressed() {

        finish();
        Intent i = new Intent(this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}
