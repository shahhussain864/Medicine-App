package com.example.medicineapp.ui.util.room.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.medicineapp.ui.util.room.UserInfo;
import com.example.medicineapp.ui.util.room.dao.UserInfoDataSource;

@Database(entities = { UserInfo.class }, version =1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserInfoDataSource userInfoDataSource();


}
