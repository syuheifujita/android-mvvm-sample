package com.syuheifujita.android_mvvm_sample.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class AlcoholListDao {
    private val alcoholList = mutableListOf<Alcohol>()
    private val alcohols = MutableLiveData<List<Alcohol>>()

    init {
        alcohols.value = alcoholList
    }

    // LiveDataクラスで，アイテムの更新を行っている？？
    fun addAlcohol(alcohol: Alcohol) {
        alcoholList.add(alcohol)
        alcohols.value = alcoholList
    }

    fun getAlcohols() = alcohols as LiveData<List<Alcohol>>
}
