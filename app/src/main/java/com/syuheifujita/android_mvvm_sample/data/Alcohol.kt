package com.syuheifujita.android_mvvm_sample.data

data class Alcohol(
    val titleText: String,
    val author: String
) {
    override fun toString(): String {
        return "$titleText - $author"
    }
}
