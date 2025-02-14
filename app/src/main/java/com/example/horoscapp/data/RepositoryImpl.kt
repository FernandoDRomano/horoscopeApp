package com.example.horoscapp.data

import android.util.Log
import com.example.horoscapp.data.network.HoroscopeApiService
import com.example.horoscapp.domain.Repository
import com.example.horoscapp.domain.model.PredictionModel
import retrofit2.Retrofit
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService):Repository{
    override suspend fun getPrediccion(sing: String):PredictionModel? {
        //Llamar retrofit
        runCatching {
            apiService.getHoroscope(sing)
        }.onSuccess {
            return it.toDomain()
        }.onFailure {
            Log.i("fernando", "Ha ocurrido un error ${it.message}")
        }

        return null
    }
}