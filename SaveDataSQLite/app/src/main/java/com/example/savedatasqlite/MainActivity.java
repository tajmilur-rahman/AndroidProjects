package com.example.savedatasqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.savedatasqlite.EntityClass.User;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edtName);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        Button btnView = (Button) findViewById(R.id.btnView);

        dbHelper = new DatabaseHelper(this);

        btnAdd.setOnClickListener(l -> {
            String name = editText.getText().toString();
            if(validateInputField(name) == null) {
                addData(name);
                editText.setText("");
            } else {
                Toast.makeText(this, "You must put a name in the name field!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnView.setOnClickListener(l -> {
            Intent intent = new Intent(MainActivity.this, ListDataActivity.class);
            startActivity(intent);
        });
    }

    public String validateInputField(String s) {
        if(s.length() == 0) {
            return "Input field is empty";
        }
        return null;
    }

    public void addData(String name) {
        // Add data using Room Database
        User user = new User();
        user.setName(name);
        AsyncTask.execute(() -> AbstractDatabase.getDatabase(getApplicationContext())
                .getUserDao()
                .insert(user));
    }
}