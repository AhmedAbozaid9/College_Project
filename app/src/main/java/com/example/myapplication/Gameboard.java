package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Objects;

public class Gameboard extends AppCompatActivity {

    public String[] scoreBoard = new String[9];
    Boolean isPlayer1 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ImageView imageview;
        super.onCreate(savedInstanceState);
        //hiding the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_gameboard);

        Button returnBtn = (Button) findViewById(R.id.button_return);
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Home.class);
                view.getContext().startActivity(intent);
            }
        });
        ImageButton b0 = findViewById(R.id.imageButton00);
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               handleClick(b0,0);
            }
        });
        ImageButton b1 = findViewById(R.id.imageButton01);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClick(b1,1);
            }
        });
        ImageButton b2 = findViewById(R.id.imageButton02);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               handleClick(b2,2);

            }
        });
        ImageButton b3 = findViewById(R.id.imageButton10);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               handleClick(b3,3);
            }
        });
        ImageButton b4 = findViewById(R.id.imageButton11);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClick(b4,4);
            }
        });
        ImageButton b5 = findViewById(R.id.imageButton12);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClick(b5,5);

            }
        });
        ImageButton b6 = findViewById(R.id.imageButton20);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClick(b6,6);
            }
        });
        ImageButton b7 = findViewById(R.id.imageButton21);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               handleClick(b7,7);
            }
        });
        ImageButton b8 = findViewById(R.id.imageButton22);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClick(b8,8);
            }
        });

    }

    public void handleClick(ImageButton btn,int idx) {

        if (isPlayer1) {
            scoreBoard[idx] = "x";
            btn.setImageResource(R.drawable.x_icon);
        } else {
            scoreBoard[idx] = "o";
            btn.setImageResource(R.drawable.o_icon);
        }
    }
    private boolean checkForWin() {
        String[][] field = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && !field[i][0].equals("")) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][i].equals("")) {
                return true;
            }
        }

        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals("")) {
            return true;
        }

        if (field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals("")) {
            return true;
        }

        return false;
    }
}

