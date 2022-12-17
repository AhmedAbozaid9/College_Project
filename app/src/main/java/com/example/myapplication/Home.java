package com.example.myapplication;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Objects;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        //hiding the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);

        //navigation
        ImageButton score = (ImageButton) findViewById(R.id.score);
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ScoreBoard.class);
                view.getContext().startActivity(intent);}
        });
        ImageButton history = (ImageButton) findViewById(R.id.history);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), History.class);
                view.getContext().startActivity(intent);}
        });
        Button TwoPlayer = (Button) findViewById(R.id.button6);
        TwoPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Gameboard.class);
                view.getContext().startActivity(intent);}
        });
        Button Single_Player = (Button) findViewById(R.id.button2);
        Single_Player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), GameBoardAi.class);
                view.getContext().startActivity(intent);}
        });




    }
}