package com.example.animationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean bartIsShowing = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fade(View view) {
        Log.i("IMGAGE: ", "Fading bart image to homer.");
        ImageView imageView1 = findViewById(R.id.imageView1);
        ImageView imageView2 = findViewById(R.id.imageView2);

        //imageView1.animate().translationXBy(-1100).setDuration(2000);
        //imageView1.animate().rotation(1800).setDuration(1000);
        imageView1.animate().scaleX(0.5f).scaleY(0.5f).setDuration(2000);
    }
//    public void fade(View view) {
//        Log.i("IMGAGE: ", "Fading bart image to homer.");
//        ImageView imageView1 = findViewById(R.id.imageView1);
//        ImageView imageView2 = findViewById(R.id.imageView2);
//
//        if(bartIsShowing) {
//            imageView1.animate().alpha(0).setDuration(2000);
//            imageView2.animate().alpha(1).setDuration(2000);
//            bartIsShowing = false;
//        } else {
//            imageView1.animate().alpha(1).setDuration(2000);
//            imageView2.animate().alpha(0).setDuration(2000);
//            bartIsShowing = true;
//        }
//    }
}