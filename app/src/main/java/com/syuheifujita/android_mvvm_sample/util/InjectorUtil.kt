package com.syuheifujita.android_mvvm_sample.util

import com.syuheifujita.android_mvvm_sample.data.AlcoholRepository
import com.syuheifujita.android_mvvm_sample.data.FakeDatabase
import com.syuheifujita.android_mvvm_sample.ui.AlcoholViewModelFactory

// 複雑なプロジェクトであれば，ここではDagger2を使う
//このクラスが呼び出し元
object InjectorUtil {
    fun provideAlcoholViewModelFactory() : AlcoholViewModelFactory {
        val alcoholRepository = AlcoholRepository.getInstance(FakeDatabase.getInstance().alcoholDao)
        return AlcoholViewModelFactory(alcoholRepository)
    }
}
