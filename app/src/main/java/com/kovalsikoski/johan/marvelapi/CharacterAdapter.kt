package com.kovalsikoski.johan.marvelapi

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.cardview_character.view.*


class CharacterAdapter(private val characterList: MutableList<MarvelModel.MarvelPage.Character>,
                       private val context: Context,
                       val listener: ClickInterface) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cardview_character, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = characterList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characterList[position]
        holder.bindView(character, listener)

    }

    fun add(character: MarvelModel.MarvelPage.Character){
        characterList.add(character)
        notifyItemInserted(characterList.size-1)
    }

    fun addAll(characterList: MutableList<MarvelModel.MarvelPage.Character>){
        characterList.forEach { add(it) }
    }

    fun remove(character: MarvelModel.MarvelPage.Character){
        val position = characterList.indexOf(character)
        if(position > -1) {
            characterList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun getItem(position: Int) = characterList[position]

    fun clear(){
        while (itemCount > 0){
            remove(getItem(0))
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(character: MarvelModel.MarvelPage.Character, listener: ClickInterface) {
            val characterTextView = itemView.character_name_textview

            itemView.setOnClickListener {
                listener.onClick(character)
            }

            characterTextView.text = character.name
            characterTextView.contentDescription = character.name
        }
    }

    interface ClickInterface {
        fun onClick(character: MarvelModel.MarvelPage.Character)
    }
}