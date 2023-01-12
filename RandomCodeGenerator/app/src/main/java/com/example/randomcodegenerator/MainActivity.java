package com.example.randomcodegenerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnRoll;
    TextView textView;
    SeekBar seekBar;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRoll = (Button) findViewById(R.id.btnRoll);
        textView = (TextView) findViewById(R.id.textView);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        btnRoll.setOnClickListener(l -> {
            Random random = new Random();
            int range = seekBar.getProgress();
            range = (range <= 0) ? 1 : range;
            int v = random.nextInt(range);
            textView.setText(Integer.toString(v));
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.home:
                setContentView(R.layout.activity_main);
                break;
            case R.id.about_this_game:
                setContentView(R.layout.about_this_game);
                break;
            case R.id.contact_us:
                setContentView(R.layout.contact_us);
                break;
            case R.id.exit:
                finish();
        }
        return false;
    }

    public void aboutThisGame(View view) {
        setContentView(R.layout.about_this_game);
    }

    public void contactUs(View view) {
        setContentView(R.layout.contact_us);
    }

    public void gotoHome(View view) {
        setContentView(R.layout.activity_main);
    }
}