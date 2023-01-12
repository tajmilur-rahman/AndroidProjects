package com.example.randomizer_sp22;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnRoll;
    TextView textView1;
    SeekBar seekBar;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Take the view objects
        btnRoll = findViewById(R.id.btnRoll);
        textView1 = findViewById(R.id.txtView1);
        seekBar = findViewById(R.id.seekBar);

        btnRoll.setOnClickListener(l -> {
            Random random = new Random();
            int range = seekBar.getProgress();
            range = (range <= 0) ? 1 : range;

            int v = random.nextInt(range);

            textView1.setText(Integer.toString(v));
        });
    }
}