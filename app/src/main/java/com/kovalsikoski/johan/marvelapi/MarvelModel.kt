package com.kovalsikoski.johan.marvelapi

data class MarvelModel (var code: Int, var data: MarvelPage) {

    inner class MarvelPage (var offset: Int, var total: Int, var results: List<Character>) {

        inner class Character (var name: String, var description: String, var thumbnail: Thumbnail, var comics: Comic){

            inner class Thumbnail(var path: String, var extension: String)

            inner class Comic (var items: List<Item>) {

                inner class Item (var name: String)
            }
        }
    }
}

