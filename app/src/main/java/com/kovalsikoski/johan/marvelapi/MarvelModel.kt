package com.kovalsikoski.johan.marvelapi

data class MarvelModel (var code: Int, var status: String, var data: MarvelPage) {

    inner class MarvelPage (var total: Int, var count: Int, var results: List<Characters>) {

        inner class Characters (var name: String)
    }
}

