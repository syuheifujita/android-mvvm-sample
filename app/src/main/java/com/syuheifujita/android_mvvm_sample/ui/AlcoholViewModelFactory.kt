package com.syuheifujita.android_mvvm_sample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.syuheifujita.android_mvvm_sample.data.AlcoholRepository

// ViewModelを直接作成することはできないので，代わりにこのクラスを作る
class AlcoholViewModelFactory(private val alcoholRepository: AlcoholRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AlcoholViewModel(alcoholRepository) as T
    }

}
