package com.example.savedatasqlite;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.savedatasqlite.DaoClass.UserDao;
import com.example.savedatasqlite.EntityClass.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AbstractDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();
    private static AbstractDatabase instance;
    private static final RoomDatabase.Callback sOnOpenCallback =
            new RoomDatabase.Callback(){
                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                }};

    public static AbstractDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (AbstractDatabase.class) {
                instance = Room.databaseBuilder(context, AbstractDatabase.class, "SAVE_DATA_SQLITE")
                        .addCallback(sOnOpenCallback)
                        // fallbackToDestructiveMigration() Allows Room to destructively recreate
                        // database tables if Migrations that would migrate old database schemas
                        // to the latest schema version are not found.
                        // When the database version on the device does not match the latest schema
                        // version, Room runs necessary Migrations on the database.
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }

        return instance;
    }

}
