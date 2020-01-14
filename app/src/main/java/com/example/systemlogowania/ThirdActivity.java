package com.example.systemlogowania;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class ThirdActivity extends AppCompatActivity {

    private Button wyloguj;
    private ImageView kosci;
    private Random losowanie = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        kosci = findViewById(R.id.imageViewDice);
        kosci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rzutKoscmi();
            }
        });

        wyloguj = (Button)findViewById(R.id.przyciskWyloguj);

        wyloguj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void rzutKoscmi() {
        int losowaLiczba = losowanie.nextInt(6) + 1;
        switch(losowaLiczba) {
            case 1:
                kosci.setImageResource(R.drawable.dice1);
                break;
            case 2:
                kosci.setImageResource(R.drawable.dice2);
                break;
            case 3:
                kosci.setImageResource(R.drawable.dice3);
                break;
            case 4:
                kosci.setImageResource(R.drawable.dice4);
                break;
            case 5:
                kosci.setImageResource(R.drawable.dice5);
                break;
            case 6:
                kosci.setImageResource(R.drawable.dice6);
                break;
        }
    }
}