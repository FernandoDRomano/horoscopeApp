package com.example.horoscapp.domain

import com.example.horoscapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediccion(sing:String): PredictionModel?
}