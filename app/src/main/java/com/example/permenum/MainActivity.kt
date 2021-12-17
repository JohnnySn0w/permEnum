package com.example.permenum

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val permList:Array<String> = resources.getStringArray(R.array.PermList)
        val list = genList(permList)
        val recycler_view:RecyclerView = findViewById(R.id.recycler_view)
        recycler_view.adapter = adaptor(list)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }

    private fun genList(permList: Array<String>): List<item>{
        val list = ArrayList<item>()
        for (perm in permList) {
            var drawable = R.drawable.ic_baseline_cancel_24
            var has = "does not have"
            if (ContextCompat.checkSelfPermission(baseContext, perm) == PackageManager.PERMISSION_GRANTED){
                drawable = R.drawable.ic_baseline_radio_button_unchecked_24
                has = "does have"
            }
            val item = item(drawable, "Item $perm", has) //replace text1 with perm name and 2 with has/doesn't
            list += item
        }
        return list
    }
}