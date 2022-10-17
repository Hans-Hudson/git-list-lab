package com.uranium.gitlist.setup.remote

import com.uranium.gitlist.BuildConfig
import okhttp3.OkHttpClient
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RemoteModule {
    val remote: Module = module {
        factory { provideOkHttpClient() }
        single {
            provideRetrofit(get())
        }
        single { HttpClient(get()) }
    }

    private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(BuildConfig.API_URL).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    private fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder().addInterceptor(HeaderInterceptor()).build()
    }
}