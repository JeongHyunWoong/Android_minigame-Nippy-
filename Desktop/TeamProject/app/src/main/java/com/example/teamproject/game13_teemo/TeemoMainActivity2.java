package com.example.teamproject.game13_teemo;

import static com.example.teamproject.game01_shake.ShakeGameActivity.count;
import static com.example.teamproject.game13_teemo.TeemoMainActivity1.scoreNumb;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teamproject.MainActivity;
import com.example.teamproject.MySQLiteOpenHelper_teemo;
import com.example.teamproject.R;

public class TeemoMainActivity2 extends AppCompatActivity {

    //SQLITE 데이타베이스 관련변수
    SQLiteDatabase db;
    MySQLiteOpenHelper_teemo helper;

    String name, score; //입력값을 변수에 저장해서 insert처리할변수

    Button btnEnter, btnMain, button3;
    EditText et_highscore_score, et_highscore_name;
    //TextView  tv_highscore_score;

    String TAG ="회원가입 예제";

    public static MediaPlayer mp; // 메뉴 배경 오디오

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_13main2_teemo);

        //데이베이스 생성.
        helper = new MySQLiteOpenHelper_teemo(
                TeemoMainActivity2.this, // 현재 화면의 context
                "member13.db", // 파일명
                null, // 커서 팩토리
                1); // 버전 번호

        btnEnter = (Button)findViewById(R.id.btnEnter);
        btnMain = (Button)findViewById(R.id.btnMain);
        button3 = (Button)findViewById(R.id.button3);

        et_highscore_name = (EditText)findViewById(R.id.best);
        et_highscore_score = (EditText)findViewById(R.id.score);
        //tv_highscore_score = (TextView) findViewById(R.id.tv_highscore_score);

        btnEnter.setOnClickListener(mClickListener);
        btnMain.setOnClickListener(mClickListener);
        button3.setOnClickListener(mClickListener);

        String point = Integer.toString(scoreNumb);
        et_highscore_score.setText("Score : " + scoreNumb);
        score = et_highscore_score.getText().toString();
//        tv_highscore_score.setText(point);
//        score = tv_highscore_score.getText().toString();
    }
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnEnter:
                    //공백체크
                    if(et_highscore_name.getText().toString().equals("")) {
                        et_highscore_name.setText("AAA");
                        Toast.makeText(TeemoMainActivity2.this, "이름이 없어 AAA 자동 입력!", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    //공백없이 입력잘되었을경우 변수에 저장
                    name = et_highscore_name.getText().toString();

                    //회원정보를 다 입력하였을경우 데이타베이스에 insert를 호출
                    insert(name, score);

//                    //회원가입 후 저장정보 확1인하기.
//                    intentJoinOk.putExtra("pw", name);
//                    intentJoinOk.putExtra("name", score);
//                    startActivity(intentJoinOk);

                    TeemoMainActivity1 PA = (TeemoMainActivity1)TeemoMainActivity1.teemogame; // 다른 액티비티 종료 3, 다른 액티비티에서 객체 생성
                    PA.finish(); // 다른 액티비티 종료 4, 만든 객체로 원하는 작업 실행
                    finish();
                    break;

                case R.id.btnMain:
                    Intent ex1 = new Intent(TeemoMainActivity2.this, MainActivity.class);
                    startActivity(ex1);
                    finish();
                    mp.stop();
                    break;

                case R.id.button3:
                    Intent ex2 = new Intent(TeemoMainActivity2.this, TeemoMainActivity.class);
                    startActivity(ex2);
                    finish();
                    mp.stop();
                    break;
            }
        }
    };

    //데이타베이스 메서드 처리  ////////////////////////////
    public void insert(String name, String score) {

        db = helper.getWritableDatabase(); // db 객체를 얻어온다. 쓰기 가능

        //값들을 컨트롤 하려고 클래스 생성
        ContentValues values = new ContentValues();

        // db.insert의 매개변수인 values가 ContentValues 변수이므로 그에 맞춤
        // 데이터의 삽입은 put을 이용한다.
        values.put("name", name);
        values.put("score", score);
        db.insert("member", null, values); // 테이블/널컬럼핵/데이터(널컬럼핵=디폴트)

        // tip : 마우스를 db.insert에 올려보면 매개변수가 어떤 것이 와야 하는지 알 수 있다.
        db.close();

        Log.d(TAG, name+"/"+score+" 의 정보로 디비저장완료.");
    }
    // 뒤로 버튼을 눌러서 액티비티 종료
    @Override
    public void onBackPressed() {
        if (TeemoMainActivity1.handler2 != null) {
            TeemoMainActivity1.handler2.removeMessages(0);
            TeemoMainActivity1.handler2.removeCallbacks(null);
            TeemoMainActivity1.handler2.removeCallbacksAndMessages(null);
        }
//        if(MainActivity.media_player_start_menu_2 != null &&  MainActivity.media_player_start_menu_2.isPlaying()) {
//            return;
//        } else {
//            media_player_start_menu_2 = MediaPlayer.create(ScoreInput.this, R.raw.main_menu_02_in_the_name_of_strikers);
//            media_player_start_menu_2.start();                     // 메인메뉴 오디오 시작 2
//            media_player_start_menu_2.setLooping(true);            // 메인메뉴 오디오 무한루프 2
//        }
        count = 0;
        super.finish(); // 액티비티 종료
    }
}
