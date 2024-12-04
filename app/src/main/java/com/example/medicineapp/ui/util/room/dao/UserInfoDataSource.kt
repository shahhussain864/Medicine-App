package com.example.medicineapp.ui.util.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.medicineapp.ui.util.room.UserInfo

@Dao
abstract class UserInfoDataSource {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertUser(items: UserInfo)

    @Query("SELECT * from UserInfo")
    abstract suspend fun getUser(): UserInfo?


}