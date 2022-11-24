package com.example.teamproject.game10_minus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teamproject.MainActivity;
import com.example.teamproject.R;

public class MinusMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_10main_minus);

        findViewById(R.id.btn1).setOnClickListener(mClick);
        findViewById(R.id.btn2).setOnClickListener(mClick);
        findViewById(R.id.btn3).setOnClickListener(mClick);

    }
    Button.OnClickListener mClick = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn1:
                    Intent ex1 = new Intent(MinusMainActivity.this, MinusMainActivity1.class);
                    startActivity(ex1);
                    break;
                case R.id.btn2:
                    Intent ex2 = new Intent(MinusMainActivity.this, MinusMainActivity2.class);
                    startActivity(ex2);
                    break;
                case R.id.btn3:
                    Intent ex3 = new Intent(MinusMainActivity.this, MinusMainActivity3.class);
                    startActivity(ex3);
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
