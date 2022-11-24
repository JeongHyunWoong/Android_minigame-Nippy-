package com.example.teamproject.game10_minus;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teamproject.R;

import java.util.ArrayList;
import java.util.Random;

public class MinusMainActivity1 extends AppCompatActivity {

    private ImageView solution;
    private TextView timerTextView;
    private TextView expressionTextView;
    private TextView scoreTextView;
    private TextView resultTextView;
    private Button playAgainButton;
    private int resultOfSum;
    private int outOfScore = 0;
    private int scoreAchieved = 0;
    TextView zeroth;
    TextView first;
    TextView second;
    TextView third;
    ColorStateList color;

    private SoundPool soundPool;
    private int sound1, sound2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_10main1_minus);
        timerTextView = (TextView) findViewById(R.id.timer_text_view);
        expressionTextView = (TextView) findViewById(R.id.expression_text_view);
        scoreTextView = (TextView) findViewById(R.id.score_text_view);
        resultTextView = (TextView) findViewById(R.id.result_text_view);
        playAgainButton = (Button) findViewById(R.id.play_again_button);
        zeroth=(TextView)findViewById(R.id.zeroth_text_view);
        first=(TextView)findViewById(R.id.first_text_view);
        second=(TextView)findViewById(R.id.second_text_view);
        third=(TextView)findViewById(R.id.third_text_view);
        color=timerTextView.getTextColors();
        solution = (ImageView) findViewById(R.id.solution);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            soundPool = new SoundPool.Builder().setMaxStreams(10).build();
        }
        else{
            soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        }
        sound1 = soundPool.load(this, R.raw.solution,1);
        sound2 = soundPool.load(this, R.raw.fail,1);

        solution.setVisibility(View.GONE);

    }

    public void optionClicked(View view) {
        outOfScore++;
        TextView i = (TextView) view;
        if (Integer.parseInt(i.getText().toString()) == resultOfSum) {
            scoreAchieved++;
            resultTextView.setText("정답!");
            soundPool.play(sound1, 1, 1, 0, 0, 1);
            scoreTextView.setText(scoreAchieved + "/" + outOfScore);
            solution.setVisibility(View.VISIBLE);
            setOptions();
        } else {
            resultTextView.setText("땡!");
            soundPool.play(sound2, 1, 1, 0, 0, 1);
            scoreTextView.setText(scoreAchieved + "/" + outOfScore);
            solution.setVisibility(View.INVISIBLE);
            setOptions();
        }
    }

    public void playAgain(View view) {
        zeroth.setEnabled(true);
        first.setEnabled(true);
        second.setEnabled(true);
        third.setEnabled(true);
        startTimer();
        setOptions();
        playAgainButton.setVisibility(View.INVISIBLE);
        scoreTextView.setText("0/0");
        timerTextView.setTextColor(color);
        resultTextView.setText("");
    }

    public void startTimer() {
        CountDownTimer timer = new CountDownTimer(20100, 1000) {
            @Override
            public void onTick(long l) {
                if((l/1000)>5)
                    timerTextView.setText(Integer.toString((int) l / 1000) + "s");
                else{
                    timerTextView.setText(Integer.toString((int) l / 1000) + "s");
                    timerTextView.setTextColor(Color.parseColor("#D50000"));
                }
            }

            @Override
            public void onFinish() {
                zeroth.setEnabled(false);
                first.setEnabled(false);
                second.setEnabled(false);
                third.setEnabled(false);
                timerTextView.setText("0s");
                int score=scoreAchieved-(outOfScore-scoreAchieved);
                resultTextView.setText("Score : " +score);
                playAgainButton.setVisibility(View.VISIBLE);
                scoreAchieved=0;
                outOfScore=0;
            }
        }.start();
    }

    public void setOptions() {
        Random random = new Random();
        int n1 = random.nextInt(10);
        int n2 = random.nextInt(10);
        resultOfSum = n1 - n2;
        expressionTextView.setText(n1 + "-" + n2);
        ArrayList<Integer> options= new ArrayList<>();
        int positionOfAnswer = random.nextInt(4);
        int incorrectAnswer;
        for (int i = 0; i < 4; i++) {
            if (i == positionOfAnswer) {
                options.add(resultOfSum);
            } else {
                incorrectAnswer = random.nextInt(10);
                while (incorrectAnswer == resultOfSum) {
                    incorrectAnswer = random.nextInt(10);
                }
                options.add(incorrectAnswer);
            }
        }
        TextView zeroth = (TextView) findViewById(R.id.zeroth_text_view);
        TextView first = (TextView) findViewById(R.id.first_text_view);
        TextView second = (TextView) findViewById(R.id.second_text_view);
        TextView third = (TextView) findViewById(R.id.third_text_view);

        zeroth.setText(Integer.toString(options.get(0)));
        first.setText(Integer.toString(options.get(1)));
        second.setText(Integer.toString(options.get(2)));
        third.setText(Integer.toString(options.get(3)));
    }
    public void goClicked(View view){
        TextView goTextView=(TextView)findViewById(R.id.go_text_view);
        GridLayout gridLayout=(GridLayout)findViewById(R.id.grid_layout);
        goTextView.setVisibility(View.INVISIBLE);
        timerTextView.setVisibility(View.VISIBLE);
        expressionTextView.setVisibility(View.VISIBLE);
        scoreTextView.setVisibility(View.VISIBLE);
        gridLayout.setVisibility(View.VISIBLE);
        startTimer();
        setOptions();
    }
}