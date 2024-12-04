package com.example.medicineapp.ui.util.hilt

import android.content.Context
import androidx.room.Room
import com.example.medicineapp.ui.util.retrofit.ApiService
import com.example.medicineapp.ui.util.room.database.AppDatabase
import com.example.medicineapp.ui.util.room.dao.UserInfoDataSource
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext application: Context): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "talkhome_db")
            .build()
    }

    @Singleton
    @Provides
    fun getAppDaoImplementationForUserInfo(
        app:AppDatabase
    ): UserInfoDataSource {

        return app.userInfoDataSource()
    }

    @Singleton
    @Provides
    fun getApiService(
    ): ApiService {
        val contentType = MediaType.parse("application/json")

        return   Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .addConverterFactory(contentType?.let {
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                }.asConverterFactory(it)
            })
            .build()
            .create(ApiService::class.java)
    }


}
