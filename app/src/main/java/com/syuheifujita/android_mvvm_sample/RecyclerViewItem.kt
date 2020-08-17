package com.syuheifujita.android_mvvm_sample

import com.syuheifujita.android_mvvm_sample.databinding.ItemRecyclerviewBinding
import com.xwray.groupie.databinding.BindableItem

class RecyclerViewItem(val text: String): BindableItem<ItemRecyclerviewBinding>() {
    override fun getLayout() = R.layout.item_recyclerview

    override fun bind(viewBinding: ItemRecyclerviewBinding, position: Int) {
        //viewmodelだとここが違う
        viewBinding.text = text
//        viewBinding.textView.setText(text)
    }
}
