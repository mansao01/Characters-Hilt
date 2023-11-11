package com.mansao.characterhilt.di

import android.content.Context
import androidx.room.Room
import com.mansao.characterhilt.BuildConfig
import com.mansao.characterhilt.data.local.CharacterDatabase
import com.mansao.characterhilt.data.remote.ApiConst
import com.mansao.characterhilt.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    //Room
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): CharacterDatabase {
        return Room.databaseBuilder(
            context,
            CharacterDatabase::class.java,
            "character_db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideCharacterDao(database: CharacterDatabase) = database.characterDao()

    //    retrofit
    @Singleton
    @Provides
    fun getApiService(): Retrofit {
        val loggingInterceptor = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        return Retrofit.Builder()
            .baseUrl(ApiConst.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        val apiService: ApiService by lazy { retrofit.create(ApiService::class.java) }
        return apiService
    }
}