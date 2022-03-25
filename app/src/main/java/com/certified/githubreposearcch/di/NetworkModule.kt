package com.certified.githubreposearcch.di

import com.certified.githubreposearcch.utils.Config.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, client: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(BASE_URL)
        .client(client)
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder()
        .setLenient()
        .create()

    @Provides
    fun provideLogger() = HttpLoggingInterceptor()
//    logger.level = Level.BASIC

    @Provides
    fun provideClient(logger: HttpLoggingInterceptor): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(logger)
        .build()
}