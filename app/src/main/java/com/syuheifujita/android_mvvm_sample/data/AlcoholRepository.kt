package com.syuheifujita.android_mvvm_sample.data

class AlcoholRepository private constructor(private val alcoholDao: AlcoholListDao) {

    fun addAlcohol(alcohol: Alcohol) {
        alcoholDao.addAlcohol(alcohol)
    }

    fun getAlcohol() = alcoholDao.getAlcohols()

    companion object {
        @Volatile private var instance: AlcoholRepository? = null

        fun getInstance(alcoholDao: AlcoholListDao) =
//            if (instance != null) {
//                synchronized(this) {
//                    if (instance != null) {
//                        AlcoholRepository(alcoholDao).also { instance = it }
//                    }
//                }
//            }

            // ここをif分でかけないかなあ
            instance ?: synchronized(this) {
                instance ?: AlcoholRepository(alcoholDao).also { instance = it }
            }
    }
}

// 3つはRoom, LiveDataに関するグループ
// AlcoholListDao
// FakeDatabase
// AlcoholRepository
