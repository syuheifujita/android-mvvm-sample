package com.syuheifujita.android_mvvm_sample.ui

import androidx.lifecycle.ViewModel
import com.syuheifujita.android_mvvm_sample.data.Alcohol
import com.syuheifujita.android_mvvm_sample.data.AlcoholRepository

class AlcoholViewModel(private val  alcoholRepository: AlcoholRepository) : ViewModel() {
    fun addAlcohol(alcohol: Alcohol) = alcoholRepository.addAlcohol(alcohol)

    fun getAlcohol() = alcoholRepository.getAlcohol()
}
