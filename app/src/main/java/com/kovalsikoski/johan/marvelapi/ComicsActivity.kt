package com.kovalsikoski.johan.marvelapi

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_comics.*

class ComicsActivity: AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ComicsAdapter

    private var layoutManager = GridLayoutManager(this, StaggeredGridLayoutManager.VERTICAL)

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val comics = intent.getSerializableExtra("comics") as MarvelModel.MarvelPage.Character.Comic

        recyclerViewInitializer(comics)

    }

    private fun recyclerViewInitializer(comics: MarvelModel.MarvelPage.Character.Comic){
        recyclerView = comics_recyclerview
        adapter = ComicsAdapter(comics, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
    }
}