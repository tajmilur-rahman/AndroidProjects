package com.example.userlog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.userlog.EntityClasses.User;
import com.example.userlog.ViewModels.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        // TODO: Receive the intent "Extra" here to retrieve the user name and

        UserViewModel model = new ViewModelProvider(this).get(UserViewModel.class);
        LiveData<List<User>> users = model.getUsers(getApplicationContext());
        users.observe(this, this::populateListViewFromViewModel);
    }

    private void populateListViewFromViewModel(List<User> users) {
        Log.d("UserListActivity", "populateListViewFromViewModel: Displaying data in" +
                "the ListView");

        ArrayList<String> names = new ArrayList<>();
        for (User u : users) {
            names.add(u.getName());
        }

        ListView listView = findViewById(R.id.lstViewUsers);

        // Populate the list view
        ListAdapter adapter = new ArrayAdapter<>(this, R.layout.activity_user_list, names);
        listView.setAdapter(adapter);
    }
}