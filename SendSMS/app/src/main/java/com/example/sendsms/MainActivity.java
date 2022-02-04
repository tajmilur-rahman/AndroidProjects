package com.example.sendsms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtPhoneNumber;
    private EditText txtSMSText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get view objects
        txtPhoneNumber = findViewById(R.id.txtPhoneNumber);
        txtSMSText = findViewById(R.id.txtSMSText);

        ActivityCompat.requestPermissions(
                MainActivity.this,
                new String[]{Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS},
                PackageManager.PERMISSION_GRANTED
        );
    }

    public void sendSMS(View view) {
        String smsText = txtSMSText.getText().toString();
        String phoneNumber = txtPhoneNumber.getText().toString();

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber, null, smsText, null, null);
    }
}