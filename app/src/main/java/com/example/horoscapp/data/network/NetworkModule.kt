package com.example.horoscapp.data.network

import com.example.horoscapp.BuildConfig.BASE_URL
import com.example.horoscapp.data.RepositoryImpl
import com.example.horoscapp.data.core.interceptors.AuthInterceptor
import com.example.horoscapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    /*
    * PARA CREAR LA INSTANCIA DE RETROFIT
    * */
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
        val baseURL:String = BASE_URL

        return Retrofit
            .Builder()
            .baseUrl(baseURL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpCliente(authInterceptor: AuthInterceptor):OkHttpClient{
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient
                .Builder()
                .addInterceptor(interceptor)
                .addInterceptor(authInterceptor) //Interceptor propio para el Auth
                .build()
    }

    /*
    * RETORNAR LA IMPLEMENTACION DE RETROFIT PARA HoroscopeApiService
    * */
    @Provides
    fun provideHoroscopeApiService(retrofit: Retrofit):HoroscopeApiService{
        return retrofit.create(HoroscopeApiService::class.java)
    }

    /*
    * RETORNA LA IMPLEMENTACION DEL REPOSITORIO
    * */
    @Provides
    fun provideRepository(apiService: HoroscopeApiService):Repository{
        return RepositoryImpl(apiService)
    }
}