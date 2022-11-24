package com.example.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.teamproject.game09_plus.PopupActivity09;
import com.example.teamproject.game10_minus.PopupActivity10;
import com.example.teamproject.game11_multiple.PopupActivity11;
import com.example.teamproject.game12_AO.PopupActivity12;

public class Fragment_3 extends Fragment {

    private Button btn1, btn2, btn3, btn4;
    private CardView plusCardView, minusCardView, multipleCardView,aoCardView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup View = (ViewGroup) inflater.inflate(
                R.layout.frame_3, container, false);

        btn1 = View.findViewById(R.id.btn1);
        btn2 = View.findViewById(R.id.btn2);
        btn3 = View.findViewById(R.id.btn3);
        btn4 = View.findViewById(R.id.btn4);

        plusCardView = View.findViewById(R.id.plusCardView);
        minusCardView = View.findViewById(R.id.minusCardView);
        multipleCardView = View.findViewById(R.id.multipleCardView);
        aoCardView = View.findViewById(R.id.aoCardView);

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

        plusCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PopupActivity09.class);
                intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                startActivityForResult(intent, 1);
            }
        });
        minusCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PopupActivity10.class);
                intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                startActivityForResult(intent, 1);
            }
        });
        multipleCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PopupActivity11.class);
                intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                startActivityForResult(intent, 1);
            }
        });
        aoCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PopupActivity12.class);
                intent.putExtra("data", "제한된 시간동안  빠르게 클릭하여 점수를 득점합니다.");
                startActivityForResult(intent, 1);
            }
        });
        return View;
    }

}