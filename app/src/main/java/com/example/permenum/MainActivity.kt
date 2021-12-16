package com.example.permenum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = genList(20)

        val recycler_view:RecyclerView = findViewById(R.id.recycler_view)
        recycler_view.adapter = adaptor(list)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }

    private fun genList(size: Int): List<item>{
        val list = ArrayList<item>()

        for (i in 0 until size) {
            val drawable = when (i%3) {
                0 -> R.drawable.ic_baseline_radio_button_unchecked_24
                1 -> R.drawable.ic_baseline_cancel_24
                else -> R.drawable.ic_baseline_cancel_24
            }
            val item = item(drawable, "Item $i", "Line 2") //replace text1 with perm name and 2 with has/doesn't
            list += item
        }
        return list
    }
}