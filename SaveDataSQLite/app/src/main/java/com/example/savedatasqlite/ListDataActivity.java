package com.example.savedatasqlite;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.savedatasqlite.EntityClass.User;
import com.example.savedatasqlite.ViewModel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class ListDataActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        listView = findViewById(R.id.listView);
        databaseHelper = new DatabaseHelper(this);

        // Fetch data using view model
        UserViewModel model = new ViewModelProvider(this).get(UserViewModel.class);
        model.getUsers(getApplicationContext()).observe(this, this::populateListViewFromViewModel);
    }

    public void populateListViewFromViewModel(List<User> users) {
        Log.d("ListDataActivity", "populateListViewFromViewModel: Displaying data in the ListView");

        ArrayList<String> dataList = new ArrayList<>();
        for(User u : users) {
            dataList.add(u.getName());
        }

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);
    }
}
