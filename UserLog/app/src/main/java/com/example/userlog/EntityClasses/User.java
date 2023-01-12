package com.example.userlog.EntityClasses;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_user")
public class User {
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setUser(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
