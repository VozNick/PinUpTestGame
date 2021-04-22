package com.example.pinuptestgame.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.pinuptestgame.db.entity.PersonEntity;

@Dao
public interface PersonModelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(PersonEntity entity);
}