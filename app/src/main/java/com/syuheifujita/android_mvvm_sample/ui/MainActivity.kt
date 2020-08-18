package com.syuheifujita.android_mvvm_sample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.syuheifujita.android_mvvm_sample.R
import com.syuheifujita.android_mvvm_sample.RecyclerViewItem
import com.syuheifujita.android_mvvm_sample.data.Alcohol
import com.syuheifujita.android_mvvm_sample.util.InjectorUtil
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_recyclerview.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val groupAdapter = GroupAdapter<ViewHolder>()
        findViewById<RecyclerView>(R.id.recyclerView).adapter = groupAdapter

        val items = listOf("りんご🍎", "みかん🍊", "すいか🍉", "りんご🍎", "みかん🍊", "すいか🍉")
        items.forEach {
            groupAdapter.add(
                RecyclerViewItem(
                    it
                )
            )
        }

        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectorUtil.provideAlcoholViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(AlcoholViewModel::class.java)

        viewModel.getAlcohol().observe(this, Observer { alcohol ->
            val stringBuilder = StringBuilder()
            alcohol.forEach{ alcohol ->
                stringBuilder.append("$alcohol\n\n")
            }
            textViewAlcoholList.text = stringBuilder.toString()
        })
        buttonSubmitText.setOnClickListener {
            val alcohol = Alcohol(editTextTitle.text.toString(), editTextAuthor.text.toString())
            viewModel.addAlcohol(alcohol)
            editTextTitle.setText("")
            editTextAuthor.setText("")
        }
    }
}
