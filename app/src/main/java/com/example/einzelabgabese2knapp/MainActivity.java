package com.example.einzelabgabese2knapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends Activity {

    Button b;
    Button berechnen;
    TextView serverAnswer;
    EditText inputNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = findViewById(R.id.button);
        berechnen = findViewById(R.id.button2);
        serverAnswer = findViewById(R.id.textView);
        inputNumber = findViewById(R.id.editTextNumber);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            serverAnswer.setVisibility(View.VISIBLE);
            String matrikelnummer = inputNumber.getText().toString();
            Connection con = new Connection(matrikelnummer);

            con.start();
            try{
                con.join();
            }catch (InterruptedException e){}

            serverAnswer.setText(con.getAnswer());
            }

        });
        berechnen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}