package com.example.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.teamproject.game05_stop.PopupActivity05;
import com.example.teamproject.game06_roulette.PopupActivity06;
import com.example.teamproject.game07_piano.PopupActivity07;
import com.example.teamproject.game08_mole.PopupActivity08;

public class Fragment_2 extends Fragment {

    private Button btn1, btn2, btn3, btn4;
    private CardView stopCardView, rouletteCardView, pianoCardView, moleCardView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup View = (ViewGroup) inflater.inflate(
                R.layout.frame_2, container, false);

        btn1 = View.findViewById(R.id.btn1);
        btn2 = View.findViewById(R.id.btn2);
        btn3 = View.findViewById(R.id.btn3);
        btn4 = View.findViewById(R.id.btn4);

        stopCardView = View.findViewById(R.id.stopCardView);
        rouletteCardView = View.findViewById(R.id.rouletteCardView);
        pianoCardView = View.findViewById(R.id.pianoCardView);
        moleCardView = View.findViewById(R.id.moleCardView);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ex1 = new Intent(getActivity(), Score.class);
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
                Intent ex3 = new Intent(getActivity(), Score07_piano.class);
                ex3.putExtra("data", "");
                startActivityForResult(ex3, 1);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ex4 = new Intent(getActivity(), Score08_mole.class);
                ex4.putExtra("data", "");
                startActivityForResult(ex4, 1);
            }
        });

        stopCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PopupActivity05.class);
                intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                startActivityForResult(intent, 1);
            }
        });
        rouletteCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PopupActivity06.class);
                intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                startActivityForResult(intent, 1);
            }
        });
        pianoCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PopupActivity07.class);
                intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                startActivityForResult(intent, 1);
            }
        });
        moleCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PopupActivity08.class);
                intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                startActivityForResult(intent, 1);
            }
        });
        return View;
    }

}