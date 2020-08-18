package com.syuheifujita.android_mvvm_sample.data

// AlcoholListクラスで問題があるのでここで解決
// シングルトン
//Javaの方法で
class FakeDatabase private constructor() {

    var alcoholDao = AlcoholListDao()
        private set

    companion object {
        @Volatile private var instance: FakeDatabase? = null

        fun getInstance() =
//            if (instance != null) {
//                synchronized(this) {
//                    if (instance != null) {
//                        FakeDatabase().also { instance = it }
//                    }
//                }
//            }

            // ここをif分でかけないかなあ
            instance ?: synchronized(this) {
                instance ?: FakeDatabase().also { instance = it }
            }
//        }

    }
}
