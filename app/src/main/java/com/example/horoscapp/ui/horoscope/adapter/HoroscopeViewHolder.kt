package com.example.horoscapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscapp.databinding.ItemHoroscopeBinding
import com.example.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View):RecyclerView.ViewHolder(view) {

    //VIEWBINDING
    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeinfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit){
        val context = binding.tvHoroscopeName.context
        binding.ivHoroscope.setImageResource(horoscopeinfo.img)
        binding.tvHoroscopeName.text = context.getString(horoscopeinfo.name)

        binding.parent.setOnClickListener {
            startRotationAnimation(binding.ivHoroscope, newLambda = { onItemSelected(horoscopeinfo) })
        }
    }

    private fun startRotationAnimation(view: View, newLambda: () -> Unit){
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator() //FLUJO DE LA ANIMACION, IGUAL QUE EN CSS
            rotationBy(360f) //PARA ROTAR SOBRE EL MISMO EJE
            withEndAction { newLambda() }
            start()
        }
    }
}