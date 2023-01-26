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

public class MainActivity extends AppCompatActivity {

    private  static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    String smsText, phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSendSMS = findViewById(R.id.btnSendSMS);
        btnSendSMS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText txtPhoneNumber = findViewById(R.id.txtPhoneNumber);
                EditText txtSMSText = findViewById(R.id.txtMessage);
                smsText  = txtSMSText.getText().toString();
                phoneNumber = txtPhoneNumber.getText().toString();
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
                // DO NOTHING
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

    /**
     * Overriding FragmentActivity.onRequestPermissionResult
     * @param requestCode Request code what we are requesting for
     * @param permissions permissions the permissions we are requesting granted for
     * @param grantResults permission result granted or not_granted
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.println(Log.INFO, "", "Permission to send SMS: " + MY_PERMISSIONS_REQUEST_SEND_SMS);
        // Check if the result are from what we requested for
        if (requestCode == MY_PERMISSIONS_REQUEST_SEND_SMS) {
            // Check if the permission grant code inside the result array is "PERMISSION_GRANTED"
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                send();
            } else {
                Toast.makeText(getApplicationContext(), "SMS send failed, please try again.", Toast.LENGTH_LONG).show();
            }
        }
    }
}