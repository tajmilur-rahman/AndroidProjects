package com.example.videoexample;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView = findViewById(R.id.videoView1);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.demovideo);
        // Using URI Perse
        //String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.demovideo;
        //Uri uri = Uri.parse(videoPath);
        //videoView.setVideoPath(uri);

        // Media Controller
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        // Set media controller
        videoView.setMediaController(mediaController); // this sets media controller with the parent

        videoView.start();
    }
}