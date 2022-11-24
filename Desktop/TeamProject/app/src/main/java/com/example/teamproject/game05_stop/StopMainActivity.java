package com.example.teamproject.game05_stop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teamproject.MainActivity;
import com.example.teamproject.R;

public class StopMainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_05main);

        findViewById(R.id.btn1).setOnClickListener(mClick);

    }
    Button.OnClickListener mClick = new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.btn1:
                    Intent ex1 = new Intent(StopMainActivity.this, StopMainActivity1.class);
                    startActivity(ex1);
                    break;
            }
        }
    };

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}
