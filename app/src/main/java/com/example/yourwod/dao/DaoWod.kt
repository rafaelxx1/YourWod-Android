package com.example.yourwod.dao

import com.example.yourwod.model.Wod

class DaoWod {

    fun addWod(wod: Wod){
        wods.add(wod)
    }

    fun getAllWods() : List<Wod>{
        return wods.toList()
    }

    companion object {
        private val wods = mutableListOf<Wod>()
    }

}