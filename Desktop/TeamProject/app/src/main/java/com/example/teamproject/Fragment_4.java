package com.example.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.teamproject.game01_shake.PopupActivity01;
import com.example.teamproject.game02_click.PopupActivity02;
import com.example.teamproject.game03_simon.PopupActivity03;
import com.example.teamproject.game04_same.PopupActivity04;
import com.example.teamproject.game05_stop.PopupActivity05;
import com.example.teamproject.game06_roulette.PopupActivity06;
import com.example.teamproject.game07_piano.PopupActivity07;
import com.example.teamproject.game08_mole.PopupActivity08;
import com.example.teamproject.game09_plus.PopupActivity09;
import com.example.teamproject.game10_minus.PopupActivity10;
import com.example.teamproject.game11_multiple.PopupActivity11;
import com.example.teamproject.game12_AO.PopupActivity12;
import com.example.teamproject.game13_teemo.PopupActivity13;
import com.example.teamproject.game14_oneToFifty.PopupActivity14;
import com.example.teamproject.game15_hanoi.PopupActivity15;

public class Fragment_4 extends Fragment {

    private Button btn1, btn2, btn3, btn4;
    private CardView teemoCardView, oneToFiftyCardView, hanoiCardView, randomCardView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup View = (ViewGroup) inflater.inflate(
                R.layout.frame_4, container, false);

        btn1 = View.findViewById(R.id.btn1);
        btn2 = View.findViewById(R.id.btn2);
        btn3 = View.findViewById(R.id.btn3);
        btn4 = View.findViewById(R.id.btn4);

        teemoCardView = View.findViewById(R.id.aoCardView);
        oneToFiftyCardView = View.findViewById(R.id.oneToFiftyCardView);
        hanoiCardView = View.findViewById(R.id.hanoiCardView);
        randomCardView = View.findViewById(R.id.randomCardView);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ex1 = new Intent(getActivity(), Score13_teemo.class);
                ex1.putExtra("data", "");
                startActivityForResult(ex1, 1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ex2 = new Intent(getActivity(), Score.class);
                ex2.putExtra("data", "");
                startActivityForResult(ex2, 1);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ex3 = new Intent(getActivity(), Score.class);
                ex3.putExtra("data", "");
                startActivityForResult(ex3, 1);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ex4 = new Intent(getActivity(), Score.class);
                ex4.putExtra("data", "");
                startActivityForResult(ex4, 1);
            }
        });

        teemoCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PopupActivity13.class);
                intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                startActivityForResult(intent, 1);
            }
        });
        oneToFiftyCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PopupActivity14.class);
                intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                startActivityForResult(intent, 1);
            }
        });
        hanoiCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PopupActivity15.class);
                intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                startActivityForResult(intent, 1);
            }
        });
        randomCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int randomNum = (int) (Math.random() * 15 + 1); //1~15까지 랜덤 숫자 생성
                if(randomNum==1) {
                    Intent intent = new Intent(getActivity(), PopupActivity01.class);
                    intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                    startActivityForResult(intent, 1);
                }
                if(randomNum==2) {
                    Intent intent = new Intent(getActivity(), PopupActivity02.class);
                    intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                    startActivityForResult(intent, 1);
                }
                if(randomNum==3) {
                    Intent intent = new Intent(getActivity(), PopupActivity03.class);
                    intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                    startActivityForResult(intent, 1);
                }
                if(randomNum==4) {
                    Intent intent = new Intent(getActivity(), PopupActivity04.class);
                    intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                    startActivityForResult(intent, 1);
                }
                if(randomNum==5) {
                    Intent intent = new Intent(getActivity(), PopupActivity05.class);
                    intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                    startActivityForResult(intent, 1);
                }
                if(randomNum==6) {
                    Intent intent = new Intent(getActivity(), PopupActivity06.class);
                    intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                    startActivityForResult(intent, 1);
                }
                if(randomNum==7) {
                    Intent intent = new Intent(getActivity(), PopupActivity07.class);
                    intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                    startActivityForResult(intent, 1);
                }
                if(randomNum==8) {
                    Intent intent = new Intent(getActivity(), PopupActivity08.class);
                    intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                    startActivityForResult(intent, 1);
                }
                if(randomNum==9) {
                    Intent intent = new Intent(getActivity(), PopupActivity09.class);
                    intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                    startActivityForResult(intent, 1);
                }
                if(randomNum==10) {
                    Intent intent = new Intent(getActivity(), PopupActivity10.class);
                    intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                    startActivityForResult(intent, 1);
                }
                if(randomNum==11) {
                    Intent intent = new Intent(getActivity(), PopupActivity11.class);
                    intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                    startActivityForResult(intent, 1);
                }
                if(randomNum==12) {
                    Intent intent = new Intent(getActivity(), PopupActivity12.class);
                    intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                    startActivityForResult(intent, 1);
                }
                if(randomNum==13) {
                    Intent intent = new Intent(getActivity(), PopupActivity13.class);
                    intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                    startActivityForResult(intent, 1);
                }
                if(randomNum==14) {
                    Intent intent = new Intent(getActivity(), PopupActivity14.class);
                    intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                    startActivityForResult(intent, 1);
                }
                if(randomNum==15) {
                    Intent intent = new Intent(getActivity(), PopupActivity15.class);
                    intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                    startActivityForResult(intent, 1);
                }
            }
        });
        return View;
    }

}