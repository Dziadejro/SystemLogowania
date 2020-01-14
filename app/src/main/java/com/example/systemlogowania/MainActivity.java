package com.example.systemlogowania;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText login;
    private EditText haslo;
    private TextView proby;
    private Button loginP;
    private int licznik = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (EditText)findViewById(R.id.login);
        haslo = (EditText)findViewById(R.id.haslo);
        proby = (TextView)findViewById(R.id.tekstProby);
        loginP = (Button)findViewById(R.id.przyciskLoguj);

        loginP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                walidacja(login.getText().toString(), haslo.getText().toString());
            }
        });
    }

    private void walidacja(String uLogin, String uHaslo) {
        if ((uLogin.equals("Admin")) && (uHaslo.equals("qwerty"))) {
            licznik = 3;
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }
        else if ((uLogin.equals("Dice")) && (uHaslo.equals("Dice"))) {
            licznik = 3;
            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
            startActivity(intent);
        }
        else {
            licznik--;

            proby.setText("Liczba prób: " + String.valueOf(licznik));

            if (licznik == 0) {
                loginP.setEnabled(false);
            }
        }
    }
}
