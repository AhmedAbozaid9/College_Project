package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

public class Gameboard extends AppCompatActivity {

    public String[] gameBoard = new String[9];
    Boolean isPlayer1 = true;
    Handler handler = new Handler();

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
                cleanBoard();
                isPlayer1 = true;
                gameBoard = new String[9];
                setBoard();

            }
        });


    }

    public void setBoard() {
        setHeader();
        LinearLayout l1 = (LinearLayout) findViewById(R.id.linearLayout1);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                , ViewGroup.LayoutParams.MATCH_PARENT));
        params.weight = 1.0f;
        for (int i = 0; i < 3; i++) {
            ImageButton b0 = new ImageButton(this);
            String val = gameBoard[i];
            int finalI = i;
            b0.setOnClickListener(view -> {
                if (val == null) {
                    gameBoard[finalI] = isPlayer1 ? "x" : "o";
                    isPlayer1 = !isPlayer1;
                    cleanBoard();
                    setBoard();
                    checkBoard();

                }
            });
            b0.setLayoutParams(params);
            l1.addView(b0);

            if (Objects.equals(val, "x")) {
                b0.setImageResource(R.drawable.x_icon);
            }
            if (Objects.equals(val, "o")) {
                b0.setImageResource(R.drawable.o_icon);
            }
        }

        LinearLayout l2 = (LinearLayout) findViewById(R.id.linearLayout2);
        for (int i = 0; i < 3; i++) {
            ImageButton b0 = new ImageButton(this);
            b0.setLayoutParams(params);
            String val = gameBoard[i + 3];

            int finalI = i;
            b0.setOnClickListener(view -> {
                if (val == null) {
                    gameBoard[finalI + 3] = isPlayer1 ? "x" : "o";
                    isPlayer1 = !isPlayer1;
                    cleanBoard();
                    setBoard();
                    checkBoard();
                }
            });
            l2.addView(b0);

            if (Objects.equals(val, "x")) {
                b0.setImageResource(R.drawable.x_icon);
            }
            if (Objects.equals(val, "o")) {
                b0.setImageResource(R.drawable.o_icon);
            }
        }

        LinearLayout l3 = (LinearLayout) findViewById(R.id.linearLayout3);
        for (int i = 0; i < 3; i++) {
            ImageButton b0 = new ImageButton(this);
            String val = gameBoard[i + 6];
            int finalI = i;
            b0.setOnClickListener(view -> {
                if (val == null) {
                    gameBoard[finalI + 6] = isPlayer1 ? "x" : "o";
                    isPlayer1 = !isPlayer1;
                    cleanBoard();
                    setBoard();
                    checkBoard();
                }
            });
            b0.setLayoutParams(params);
            l3.addView(b0);

            if (Objects.equals(val, "x")) {
                b0.setImageResource(R.drawable.x_icon);
            }
            if (Objects.equals(val, "o")) {
                b0.setImageResource(R.drawable.o_icon);
            }
        }




    }

    public void setHeader() {
        TextView header = findViewById(R.id.gameHeader);

        if (isPlayer1) {
            header.setText(R.string.xTurn);
            header.setTextColor(Color.parseColor("#2196F3"));
        } else {
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

    public void checkBoard() {
        String status = "";
        TextView header = findViewById(R.id.gameHeader);
        // when to return draw
        if (!Arrays.asList(gameBoard).contains(null)) {
            status = "draw";
            header.setText(R.string.Draw);
            header.setTextColor(Color.parseColor("#000000"));
        }
        // when to win
        if ((gameBoard[0] == gameBoard[1]) && (gameBoard[1] == gameBoard[2]) && (gameBoard[0] != null)) {
            status = gameBoard[0];
            header.setText(String.format("%s wins", status.toUpperCase(Locale.ROOT)));
            header.setTextColor(Color.parseColor("#000000"));
        } else if ((gameBoard[3] == gameBoard[4]) && (gameBoard[4] == gameBoard[5]) && (gameBoard[3] != null)) {
            status = gameBoard[3];
            header.setText(String.format("%s wins", status.toUpperCase(Locale.ROOT)));
            header.setTextColor(Color.parseColor("#000000"));
        } else if ((gameBoard[6] == gameBoard[7]) && (gameBoard[7] == gameBoard[8]) && (gameBoard[6] != null)) {
            status = gameBoard[6];
            header.setText(String.format("%s wins", status.toUpperCase(Locale.ROOT)));
            header.setTextColor(Color.parseColor("#000000"));
        } else if ((gameBoard[0] == gameBoard[3]) && (gameBoard[3] == gameBoard[6])&& (gameBoard[0] != null)) {
            status = gameBoard[0];
            header.setText(String.format("%s wins", status.toUpperCase(Locale.ROOT)));
            header.setTextColor(Color.parseColor("#000000"));
        } else if ((gameBoard[1] == gameBoard[4]) && (gameBoard[4] == gameBoard[7]) && (gameBoard[1] != null)) {
            status = gameBoard[1];
            header.setText(String.format("%s wins", status.toUpperCase(Locale.ROOT)));
            header.setTextColor(Color.parseColor("#000000"));
        }else if ((gameBoard[2] == gameBoard[5]) && (gameBoard[5] == gameBoard[8]) && (gameBoard[2] != null)) {
            status = gameBoard[2];
            header.setText(String.format("%s wins", status.toUpperCase(Locale.ROOT)));
            header.setTextColor(Color.parseColor("#000000"));
        } else if ((gameBoard[0] == gameBoard[4]) && (gameBoard[4] == gameBoard[8]) && (gameBoard[0] != null)) {
            status = gameBoard[0];
            header.setText(String.format("%s wins", status.toUpperCase(Locale.ROOT)));
            header.setTextColor(Color.parseColor("#000000"));
        } else if ((gameBoard[2] == gameBoard[4]) && (gameBoard[4] == gameBoard[6]) && (gameBoard[2] != null)) {
            status = gameBoard[2];
            header.setText(String.format("%s wins", status.toUpperCase(Locale.ROOT)));
            header.setTextColor(Color.parseColor("#000000"));
        }

        if(!Objects.equals(status, "")){
            disableBoard();
            //TODO send data to firebase
            // you have status which is 'x', 'o', null
        }

    }

    public void disableBoard() {
        LinearLayout l1 = (LinearLayout) findViewById(R.id.linearLayout1);
        LinearLayout l2 = (LinearLayout) findViewById(R.id.linearLayout2);
        LinearLayout l3 = (LinearLayout) findViewById(R.id.linearLayout3);
        for (int i = 0; i < l1.getChildCount(); i++) {
            View child = l1.getChildAt(i);
            child.setEnabled(false);
        }
        for (int i = 0; i < l2.getChildCount(); i++) {
            View child = l2.getChildAt(i);
            child.setEnabled(false);
        }
        for (int i = 0; i < l3.getChildCount(); i++) {
            View child = l3.getChildAt(i);
            child.setEnabled(false);
        }
    }
}