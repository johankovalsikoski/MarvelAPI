package com.kovalsikoski.johan.marvelapi

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.cardview_character.view.*

class CharacterAdapter(private val characterList: MutableList<MarvelModel.MarvelPage.Characters>,
                       private val context: Context) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cardview_character, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = characterList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characterList[position]
        holder.bindView(character)
    }

    fun add(character: MarvelModel.MarvelPage.Characters){
        characterList.add(character)
        notifyItemInserted(characterList.size-1)
    }

    fun addAll(characterList: MutableList<MarvelModel.MarvelPage.Characters>){
        characterList.forEach { add(it) }
    }

    fun remove(character: MarvelModel.MarvelPage.Characters){
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

    /*public MyheroRecyclerViewAdapter(Context context, List<Hero> items, OnListFragmentInteractionListener listener, RecyclerView recyclerView) {
this.mHeroes = items;
mListener = listener;
this.mContext = context;
if(recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
    final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
    recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            totalItemCount = linearLayoutManager.getItemCount();
            lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
            if (!loading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                if (onLoadMoreListener != null) {
                    onLoadMoreListener.onLoadMore();
                }
                loading = true;
            }
        }
    });
}
}*/

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(character: MarvelModel.MarvelPage.Characters) {
            val characterTextView = itemView.character_name_textview

            characterTextView.text = character.name
            characterTextView.contentDescription = character.name
        }
    }
}