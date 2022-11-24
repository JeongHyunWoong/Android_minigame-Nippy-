package com.example.teamproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Score01_shake extends AppCompatActivity {

    // 스코어목록
    TextView tv_score_list;

    // SQLITE 데이타베이스 관련변수
    SQLiteDatabase db;
    MySQLiteOpenHelper_shake helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_shake);

        //데이베이스 생성.
        helper = new MySQLiteOpenHelper_shake(
                Score01_shake.this, // 현재 화면의 context
                "member1.db",         // 파일명
                null,                // 커서 팩토리
                1);                  // 버전 번호

        //회원목록
        tv_score_list = (TextView)findViewById(R.id.shake_list);

        //첫화면이라서 회원목록 전체 리스트 보이도록..호출
        selectAll();

    }
    //SQlite 메서드 처리 구간
    // 회원목록전체조회
    public void selectAll() {

        // 1) db의 데이터를 읽어와서, 2) 결과 저장, 3)해당 데이터를 꺼내 사용
        db = helper.getReadableDatabase(); // db객체를 얻어온다. 읽기 전용
        Cursor c = db.rawQuery("SELECT * FROM member order by score desc", null);
        String Result = "";
        String ReName = "";
        String ReScore = "";

        while (c.moveToNext()) {
            int idx = c.getInt(0);
            String name = c.getString(1);
            String score = c.getString(2);

            Result += "   "+name+"  |  "+score+"\n";
        }
        tv_score_list.setText(Result);
        c.close();
        db.close();
    }
    // 뒤로 버튼을 눌러서 액티비티 종료
    @Override
    public void onBackPressed() {
        super.finish(); // 액티비티 종료
    }
}