package com.example.yourwod.dao

import com.example.yourwod.model.Pr

class DaoPr {

     fun addPr(pr: Pr) {
        prs.add(pr)
    }

     fun getAllPr(): List<Pr>{
        return prs.toList()
    }


    companion object {
        private val prs = mutableListOf<Pr>()
    }
}