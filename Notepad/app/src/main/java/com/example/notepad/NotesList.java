package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.notepad.R;

public class NotesList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
    }
}