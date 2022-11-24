package com.example.teamproject.game13_teemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teamproject.MainActivity;
import com.example.teamproject.R;

public class TeemoMainActivity extends AppCompatActivity {

    RadioButton rdoEasy;
    RadioButton rdoNormal;
    RadioButton rdoHard;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_13main_teemo);

        rdoEasy = findViewById(R.id.rdoEasy);
        rdoNormal = findViewById(R.id.rdoNormal);
        rdoHard = findViewById(R.id.rdoHard);
        btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeScreen();
            }
        });
    }
    public void changeScreen() {

        Intent intent = new Intent(TeemoMainActivity.this, TeemoMainActivity1.class);

        if(rdoEasy.isChecked()){

            intent.putExtra("delayMillis",1000);

        }else if(rdoNormal.isChecked()){

            intent.putExtra("delayMillis",700);

        }else if(rdoHard.isChecked()){

            intent.putExtra("delayMillis",300);
        }
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

        finish();
        Intent i = new Intent(this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}
