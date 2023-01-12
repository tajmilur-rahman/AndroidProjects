package com.example.finalspring2022;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "acknowledged")
public class Acknowledged {
    @PrimaryKey(autoGenerate = true)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
