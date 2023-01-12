package com.example.userlog.ViewModels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.userlog.AbstractDatabase;
import com.example.userlog.EntityClasses.User;

import java.util.List;

public class UserViewModel extends ViewModel {

    private LiveData<List<User>> users;

    public LiveData<List<User>> getUsers(Context context) {
        if(users == null) {
            users = new MutableLiveData<>();
        }
        return users = AbstractDatabase.getDatabase(context).getUserDao().getAll();
    }
}
