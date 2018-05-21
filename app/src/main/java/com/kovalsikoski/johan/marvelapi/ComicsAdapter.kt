package com.kovalsikoski.johan.marvelapi

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ComicsAdapter(
        private val comics: MarvelModel.MarvelPage.Character.Comic,
        private val context: Context) : RecyclerView.Adapter<ComicsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cardview_comic, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = comics.items.size

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val comic = comics.items[position]
        holder.bindView(comic)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: MarvelModel.MarvelPage.Character.Comic.Item) {
            val comicTextView = itemView.findViewById<TextView>(R.id.comic_textview)

            comicTextView.text = item.name
            comicTextView.contentDescription = item.name
        }
    }
}