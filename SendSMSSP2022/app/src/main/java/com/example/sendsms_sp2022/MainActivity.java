package com.example.sendsms_sp2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.util.Log.ERROR;

public class MainActivity extends AppCompatActivity {

    private  static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    String smsText, phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txtPhoneNumber = findViewById(R.id.txtPhoneNumber);
        EditText txtSMSText = findViewById(R.id.txtMessage);
        Button btnSendSMS = findViewById(R.id.btnSendSMS);

        smsText  = txtSMSText.getText().toString();
        phoneNumber = txtPhoneNumber.getText().toString();

        btnSendSMS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSMS();
            }
        });
    }

    public void sendSMS () {
        Log.println(Log.INFO, "", "Will check if permission is granted or not. Current permission is: "
                + ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS));
        // Request for SEND_SMS permission if not granted already
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            Log.println(Log.INFO, "", "Permission to send SMS: " + MY_PERMISSIONS_REQUEST_SEND_SMS);
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {
            } else {
                Log.println(Log.INFO, "", "Permission to send SMS: " + MY_PERMISSIONS_REQUEST_SEND_SMS);
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        } else {
            send();
        }
    }

    private void send() {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber, null, smsText, null, null);
        Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.println(Log.INFO, "", "Permission to send SMS: " + MY_PERMISSIONS_REQUEST_SEND_SMS);
        if (requestCode == MY_PERMISSIONS_REQUEST_SEND_SMS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                send();
            } else {
                Toast.makeText(getApplicationContext(), "SMS send failed, please try again.", Toast.LENGTH_LONG).show();
            }
        }
    }
}