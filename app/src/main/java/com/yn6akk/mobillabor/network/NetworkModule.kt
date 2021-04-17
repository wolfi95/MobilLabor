package com.yn6akk.mobillabor.network

import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun provideShowsApi(client: OkHttpClient): ShowsApi {
        val retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl(NetworkConfig.API_ENDPOINT_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(ShowsApi::class.java)
    }
}