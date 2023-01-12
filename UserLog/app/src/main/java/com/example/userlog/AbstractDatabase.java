package com.example.userlog;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.userlog.DaoClasses.UserDao;
import com.example.userlog.EntityClasses.User;

@Database(entities = {User.class}, version = 1)
public abstract class AbstractDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();
    public static AbstractDatabase INSTANCE;
    private static final RoomDatabase.Callback sOnOpenCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };

    public static AbstractDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AbstractDatabase.class) {
                if (INSTANCE == null)    {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(), AbstractDatabase.class,"user_log")
                            .addCallback(sOnOpenCallback)
                            .fallbackToDestructiveMigration()
                            .build();
                }}}
        return INSTANCE;
    }
}
