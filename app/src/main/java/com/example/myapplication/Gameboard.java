package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Objects;

public class Gameboard extends AppCompatActivity {

    public String[] gameBoard = new String[9];
    Boolean isPlayer1 = true;
    // container

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("a7a", Arrays.toString(gameBoard));
        ImageView imageview;
        super.onCreate(savedInstanceState);
        //hiding the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_gameboard);
        renderBoard();

        Button returnBtn = (Button) findViewById(R.id.button_return);
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Home.class);
                view.getContext().startActivity(intent);
            }
        });


    }

    public void renderBoard(String[] board) {

        // clear the container


        for(int i = 0; i < board.length;i++){
            if(board[i] == null) {
                //render an empty button
            }
            else if(board[i] == "x"){
                //render button with x
            }
            else if(board[i] == "0") {
                //render button with o
            }
        }
    }
    public void handleClick(ImageButton btn,int idx) {
        // "x" "o" "draw"
        String status = checkBoard(gameBoard);

        if (isPlayer1) {
            gameBoard[idx] = "x";
            btn.setImageResource(R.drawable.x_icon);
        } else {
            gameBoard[idx] = "o";
            btn.setImageResource(R.drawable.o_icon);
        }
    }

    public String checkBoard(String[] board) {
        return "";
    }
}

