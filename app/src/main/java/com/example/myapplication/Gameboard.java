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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView imageview;
        super.onCreate(savedInstanceState);
        //hiding the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_gameboard);

        Button breturn = (Button) findViewById(R.id.button_return);
        breturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);
            }
        });
        ImageButton b00 = findViewById(R.id.imageButton00);
        b00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b00.setImageResource(R.drawable.x_icon);
            }
        });
        ImageButton b01 = findViewById(R.id.imageButton01);
        b01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b01.setImageResource(R.drawable.x_icon);
            }
        });
        ImageButton b02 = findViewById(R.id.imageButton02);
        b02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b02.setImageResource(R.drawable.o_icon);
            }
        });
        ImageButton b10 = findViewById(R.id.imageButton10);
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b10.setImageResource(R.drawable.o_icon);
            }
        });
        ImageButton b11 = findViewById(R.id.imageButton11);
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b11.setImageResource(R.drawable.x_icon);
            }
        });
        ImageButton b12 = findViewById(R.id.imageButton12);
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b12.setImageResource(R.drawable.o_icon);
            }
        });
        ImageButton b20 = findViewById(R.id.imageButton20);
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b20.setImageResource(R.drawable.o_icon);
            }
        });
        ImageButton b21 = findViewById(R.id.imageButton21);
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b21.setImageResource(R.drawable.o_icon);
            }
        });
        ImageButton b22 = findViewById(R.id.imageButton22);
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b22.setImageResource(R.drawable.x_icon);
            }
        });

    }
}

