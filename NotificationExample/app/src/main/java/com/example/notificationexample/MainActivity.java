package com.example.notificationexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;
    private EditText edtTitle;
    private EditText edtMsg;
    private Button btnSendOnCh1;
    private Button btnSendOnCh2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        edtTitle = findViewById(R.id.edtTitle);
        edtMsg = findViewById(R.id.edtMsg);
        btnSendOnCh1 = findViewById(R.id.btnSendOnCh1);
        btnSendOnCh2 = findViewById(R.id.btnSendOnCh2);

        btnSendOnCh1.setOnClickListener(l -> {
            Notification notification =
                    new NotificationCompat
                            .Builder(this, NotifyApplication.CHANNEL_1_ID)
                            .setSmallIcon(R.drawable.ic_one)
                            .setContentTitle(edtTitle.getText())
                            .setContentText(edtMsg.getText())
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                            .build();
            notificationManagerCompat.notify(1, notification);
        });

        btnSendOnCh2.setOnClickListener(l -> {
            Notification notification =
                    new NotificationCompat
                            .Builder(this, NotifyApplication.CHANNEL_2_ID)
                            .setSmallIcon(R.drawable.ic_two)
                            .setContentTitle(edtTitle.getText())
                            .setContentText(edtMsg.getText())
                            .setPriority(NotificationCompat.PRIORITY_LOW)
                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                            .build();
            notificationManagerCompat.notify(2, notification);
        });
    }
}