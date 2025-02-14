package com.example.horoscapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.example.horoscapp.data.providers.HoroscopeProvider
import com.example.horoscapp.domain.model.HoroscopeInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(private val horoscopeProvider: HoroscopeProvider) : ViewModel()  {
    //CREANDO EL FLOW
    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList()) //LA LISTA QUE SE PUEDE MODIFICAR
    val horoscope:StateFlow<List<HoroscopeInfo>> = _horoscope //LA LISTA QUE NO SE PUEDE MODIFICAR Y A LA QUE SE ENGANCHA EL FRAGMENT

    init {
        _horoscope.value = horoscopeProvider.getHoroscopes()
    }
}