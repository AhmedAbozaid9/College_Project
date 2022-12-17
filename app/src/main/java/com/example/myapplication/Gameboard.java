package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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

    public void handleClick(ImageButton btn,int idx) {

        if (isPlayer1) {
            scoreBoard[idx] = "x";
            btn.setImageResource(R.drawable.x_icon);
        } else {
            scoreBoard[idx] = "o";
            btn.setImageResource(R.drawable.o_icon);
        }

    }
    public void setBoard(){
        LinearLayout l1 = (LinearLayout) findViewById(R.id.linearLayout1);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                ,ViewGroup.LayoutParams.MATCH_PARENT));
        params.weight = 1.0f;
        ImageButton b0 = new ImageButton(this);
        b0.setLayoutParams(params);
        l1.addView(b0);
        ImageButton b1 = new ImageButton(this);
        b1.setLayoutParams(params);
        l1.addView(b1);
        ImageButton b2 = new ImageButton(this);
        b2.setLayoutParams(params);
        l1.addView(b2);
        LinearLayout l2 = (LinearLayout) findViewById(R.id.linearLayout2);
        ImageButton b3 = new ImageButton(this);
        b3.setLayoutParams(params);
        l2.addView(b3);
        ImageButton b4 = new ImageButton(this);
        b4.setLayoutParams(params);
        l2.addView(b4);
        ImageButton b5 = new ImageButton(this);
        b5.setLayoutParams(params);
        l2.addView(b5);
        LinearLayout l3 = (LinearLayout) findViewById(R.id.linearLayout3);
        ImageButton b6 = new ImageButton(this);
        b6.setLayoutParams(params);
        l3.addView(b6);
        ImageButton b7 = new ImageButton(this);
        b7.setLayoutParams(params);
        l3.addView(b7);
        ImageButton b8 = new ImageButton(this);
        b8.setLayoutParams(params);
        l3.addView(b8);
    }


    }


