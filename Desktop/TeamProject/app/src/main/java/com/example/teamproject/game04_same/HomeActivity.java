package com.example.teamproject.game04_same;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teamproject.R;

public class HomeActivity extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_04home);
        }

        /**
         * On button click dùng onClick trong xml
         * @param view
         */
        public void onBtnPlayClick(View view) {
            Intent intent = new Intent(this, FindSameImageGameActivity.class);
            startActivity(intent);
        }
    }