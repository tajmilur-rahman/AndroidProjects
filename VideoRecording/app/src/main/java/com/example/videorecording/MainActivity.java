package com.example.videorecording;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnVideoRecord;
    private static int REQ_CODE = 100;
    private static int IMAGE_CAPTURE_REQ_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVideoRecord = findViewById(R.id.btnRecordVideo);
        btnVideoRecord.setOnClickListener(l -> {
            recordVideo();
        });

        btnImageCapture = findViewById(R.id.btnImageCapture);
        btnImageCapture.setOnClickListener(l -> {
            captureImage();
        });

        // Check camera
        if(isCameraPresent()) {
            getCameraPermission();
            Log.i("VIDEO_RECORD_TAG", "Camera feature is detected.");
        } else {
            Log.i("VIDEO_RECORD_TAG", "Camera feature is not available.");
        }
    }

    public void getCameraPermission() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    REQ_CODE);
        }
    }

    public boolean isCameraPresent() {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    private void recordVideo() {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(intent, REQ_CODE);
    }

    private void captureImage() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, IMAGE_CAPTURE_REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == REQ_CODE) {
            if (resultCode == RESULT_OK) {
                // take the data from the intent coming in
                Uri uri = intent.getData();
                Log.i("VIDEO_RECORD_TAG", "Video has been captured and stored here: ."
                        + uri);
            } else if (resultCode == RESULT_CANCELED) {
                // log with appropriate message
                Log.i("VIDEO_RECORD_TAG", "Video recording has been cancelled.");
            } else {
                Log.i("VIDEO_RECORD_TAG", "Error occurred.");
            }
        }
        if(requestCode == IMAGE_CAPTURE_REQ_CODE) {
            //
        }

        // Set the media path for the video view.
    }

}