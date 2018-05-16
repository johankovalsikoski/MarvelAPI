package com.kovalsikoski.johan.marvelapi

data class MarvelModel (var code: Int, var data: MarvelPage) {

    inner class MarvelPage (var offset: Int, var total: Int, var count: Int, var results: List<Characters>) {

        inner class Characters (var name: String)
    }
}

