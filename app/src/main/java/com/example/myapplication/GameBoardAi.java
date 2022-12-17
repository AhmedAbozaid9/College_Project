package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

public class GameBoardAi extends AppCompatActivity {

    public String[] gameBoard = new String[9];
    Boolean isPlayer1 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hiding the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_gameboard);

        setBoard();

        Button returnBtn = (Button) findViewById(R.id.button_return);
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Home.class);
                view.getContext().startActivity(intent);
            }
        });




    }

    public void setBoard(){
        setHeader();
        LinearLayout l1 = (LinearLayout) findViewById(R.id.linearLayout1);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                ,ViewGroup.LayoutParams.MATCH_PARENT));
        params.weight = 1.0f;
        for(int i = 0 ; i < 3;i++){
            ImageButton b0 = new ImageButton(this);
            String val = gameBoard[i];
            int finalI = i;
            b0.setOnClickListener(view -> {
                if(val == null) {
                    gameBoard[finalI] = isPlayer1 ? "x" : "o";
                    isPlayer1 = !isPlayer1;
                    cleanBoard();
                    setBoard();
                }
            });
            b0.setLayoutParams(params);
            l1.addView(b0);

            if(Objects.equals(val, "x")) {
                b0.setImageResource(R.drawable.x_icon);
            }
            if(Objects.equals(val, "o")) {
                b0.setImageResource(R.drawable.o_icon);
            }
        }

        LinearLayout l2 = (LinearLayout) findViewById(R.id.linearLayout2);
        for(int i = 0 ; i < 3;i++){
            ImageButton b0 = new ImageButton(this);
            b0.setLayoutParams(params);
            String val = gameBoard[i + 3];

            int finalI = i;
            b0.setOnClickListener(view -> {
                if(val == null) {
                    gameBoard[finalI + 3] = isPlayer1 ? "x" : "o";
                    isPlayer1 = !isPlayer1;
                    cleanBoard();
                    setBoard();
                }
            });
            l2.addView(b0);

            if(Objects.equals(val, "x")) {
                b0.setImageResource(R.drawable.x_icon);
            }
            if(Objects.equals(val, "o")) {
                b0.setImageResource(R.drawable.o_icon);
            }
        }

        LinearLayout l3 = (LinearLayout) findViewById(R.id.linearLayout3);
        for(int i = 0 ; i < 3;i++){
            ImageButton b0 = new ImageButton(this);
            String val = gameBoard[i + 6];
            int finalI = i;
            b0.setOnClickListener(view -> {
                if(val == null) {
                    gameBoard[finalI + 6] = isPlayer1 ? "x" : "o";
                    isPlayer1 = !isPlayer1;
                    cleanBoard();
                    setBoard();
                }
            });
            b0.setLayoutParams(params);
            l3.addView(b0);

            if(Objects.equals(val, "x")) {
                b0.setImageResource(R.drawable.x_icon);
            }
            if(Objects.equals(val, "o")) {
                b0.setImageResource(R.drawable.o_icon);
            }
        }

    }
    public void setHeader() {
        //TODO change when the game status changes
        TextView header = findViewById(R.id.gameHeader);
        if(isPlayer1) {
            header.setText(R.string.xTurn);
            header.setTextColor(Color.parseColor("#2196F3"));
        }
        else {
            header.setText(R.string.OTurn);
            header.setTextColor(Color.parseColor("#fe827e"));
        }
    }
    public void cleanBoard() {
        LinearLayout l1 = (LinearLayout) findViewById(R.id.linearLayout1);
        l1.removeAllViews();
        LinearLayout l2 = (LinearLayout) findViewById(R.id.linearLayout2);
        l2.removeAllViews();
        LinearLayout l3 = (LinearLayout) findViewById(R.id.linearLayout3);
        l3.removeAllViews();

    }

    public String checkBoard() {
        String status = "";
        // when to return draw
        //when to return x
        //when to return o
        return "";
    }
}