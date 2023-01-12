package com.example.userlog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.userlog.EntityClasses.User;

public class MainActivity extends AppCompatActivity {

    Button btnViewList;
    Button btnAddNew;
    EditText txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnViewList = findViewById(R.id.btnViewList);
        txtName = findViewById(R.id.txtName);
        btnAddNew = findViewById(R.id.btnAddNew);
        String name = (txtName != null) ? txtName.getText().toString() : "";

        btnAddNew.setOnClickListener(l -> {
            if(name.length() <= 0) {
                txtName.setText("");
                Toast.makeText(this, "Please type a name.", Toast.LENGTH_SHORT).show();
            } else {
                // TODO: Add data into database
                User user = new User();
                user.setUser(name);
                addNewUser(user);
            }
        });

        btnViewList.setOnClickListener(l -> {
            // TODO: Create an intent

            // TODO: Create a Bundle

            // Populate the bundle
            Bundle bundle = new Bundle();
            bundle.putString("name", name);

            // TODO: Load bundle into the Intent

            // TODO: Start the Intent
        });
    }

    private void addNewUser(User user) {
        AsyncTask.execute(()->AbstractDatabase.getDatabase(getApplicationContext())
        .getUserDao()
        .insert(user));
    }
}