package com.example.savedatasqlite;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.savedatasqlite.EntityClass.User;

import java.util.List;
import java.util.Objects;

/**
 * Asynchronous Task
 */
public class MyTask extends AsyncTask<Context, Void, LiveData<List<User>>> {
    @SuppressLint("StaticFieldLeak")
    private final ListDataActivity listDataActivity;
    public MyTask(ListDataActivity listDataActivity) {
        this.listDataActivity = listDataActivity;
    }

    @Override
    public LiveData<List<User>> doInBackground(Context...contexts) {
        return AbstractDatabase.getDatabase(contexts[0]).getUserDao().getAll();
    }

    @Override
    public void onPostExecute(LiveData<List<User>> usersLive) {
        listDataActivity.populateListViewFromViewModel(Objects.requireNonNull(usersLive.getValue()));
    }
}
