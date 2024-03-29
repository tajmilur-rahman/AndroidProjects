package com.example.intent_sp22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.intent_sp22.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnDisplay).setOnClickListener(l -> {
            Intent intent = new Intent(this, DisplayMessage.class);

            // Take the message from text field
            EditText editText = findViewById(R.id.txtTextMessage);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);

            startActivity(intent);
        });
    }
}