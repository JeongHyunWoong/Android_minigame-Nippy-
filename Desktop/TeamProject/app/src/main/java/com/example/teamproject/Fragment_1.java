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

public class Fragment_1 extends Fragment {

    private Button btn1, btn2, btn3, btn4;
    private CardView shakeCardView, clickCardView, simonCardView, sameCardView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup View = (ViewGroup) inflater.inflate(
                R.layout.frame_1, container, false);

        btn1 = View.findViewById(R.id.btn1);
        btn2 = View.findViewById(R.id.btn2);
        btn3 = View.findViewById(R.id.btn3);
        btn4 = View.findViewById(R.id.btn4);

        shakeCardView = View.findViewById(R.id.shakeCardView);
        clickCardView = View.findViewById(R.id.clickCardView);
        simonCardView = View.findViewById(R.id.simonCardView);
        sameCardView = View.findViewById(R.id.sameCardView);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ex1 = new Intent(getActivity(), Score01_shake.class);
                ex1.putExtra("data", "");
                startActivityForResult(ex1, 1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ex2 = new Intent(getActivity(), Score02_click.class);
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

        shakeCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getActivity(), PopupActivity01.class);
                intent1.putExtra("data", "");
                startActivityForResult(intent1, 1);
            }
        });
        clickCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getActivity(), PopupActivity02.class);
                intent2.putExtra("data", "");
                startActivityForResult(intent2, 1);
            }
        });
        simonCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getActivity(), PopupActivity03.class);
                intent3.putExtra("data", "");
                startActivityForResult(intent3, 1);
            }
        });
        sameCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(getActivity(), PopupActivity04.class);
                intent4.putExtra("data", "");
                startActivityForResult(intent4, 1);
            }
        });
        return View;
    }
}