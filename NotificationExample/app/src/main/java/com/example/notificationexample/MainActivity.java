package com.example.notificationexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;
    private EditText edtTitle;
    private EditText edtMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        edtTitle = findViewById(R.id.edtTitle);
        edtMsg = findViewById(R.id.edtMsg);
        Button btnSendOnCh1 = findViewById(R.id.btnSendOnCh1);
        Button btnSendOnCh2 = findViewById(R.id.btnSendOnCh2);

        // Notification action intent
        Intent notificationIntent = new Intent(this, LandingActivityFromNotification.class);
        PendingIntent notificationTapIntent = PendingIntent.getActivity(
                this,
                1,
                notificationIntent,
                PendingIntent.FLAG_MUTABLE
        );

        // Click on "Send on Channel 1" button
        btnSendOnCh1.setOnClickListener(l -> {
            // Build notification
            Notification notification =
                    new NotificationCompat
                            .Builder(this, NotifyApplication.CHANNEL_1_ID)
                            .setSmallIcon(R.drawable.ic_one)
                            .setContentTitle(edtTitle.getText())
                            .setContentText(edtMsg.getText())
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                            .setContentIntent(notificationTapIntent) // Set tap action
                            .addAction(R.drawable.ic_baseline_reply_24, "Reply", notificationTapIntent) // Set action button
                            .setStyle(new NotificationCompat.BigTextStyle()
                                    .bigText(BigText.BIG_TEXT)
                                    .setBigContentTitle("The Detailed Description")
                            )
                            .build();

            // Notify
            notificationManagerCompat.notify(1, notification );
        });

        btnSendOnCh2.setOnClickListener(l -> {
            // Build notification
            Notification notification =
                    new NotificationCompat
                            .Builder(this, NotifyApplication.CHANNEL_2_ID)
                            .setSmallIcon(R.drawable.ic_two)
                            .setContentTitle(edtTitle.getText())
                            .setContentText(edtMsg.getText())
                            .setPriority(NotificationCompat.PRIORITY_LOW)
                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                            .build();

            // Notify
            notificationManagerCompat.notify(2, notification);
        });
    }
}