package com.example.sp22_practice_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Access elements
        btnA = (Button) findViewById(R.id.button2);


        // Set listener to the buttons
        btnA.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Ecxecutes when the buttons are clicked
        if(v.getId() = R.id.button2) {
            //////
        }

        if(v.getId() = R.id.button3) {
            //////
        }
    }
}