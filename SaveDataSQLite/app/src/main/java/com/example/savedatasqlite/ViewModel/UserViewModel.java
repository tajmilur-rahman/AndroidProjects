package com.example.savedatasqlite.ViewModel;

import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.savedatasqlite.AbstractDatabase;
import com.example.savedatasqlite.EntityClass.User;

import java.util.List;

public class UserViewModel extends ViewModel {
    private LiveData<List<User>> users;

    public LiveData<List<User>> getUsers(Context context) {
        if(users == null) {
            users = new MutableLiveData<>();
            users = AbstractDatabase.getDatabase(context).getUserDao().getAll();
        }
        return users;
    }
}
