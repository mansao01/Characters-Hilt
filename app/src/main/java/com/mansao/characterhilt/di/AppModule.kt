package com.mansao.characterhilt.di

import com.mansao.characterhilt.data.remote.ApiConst
import com.mansao.characterhilt.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(builder: Retrofit.Builder): ApiService {
        return builder
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(ApiConst.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }
}