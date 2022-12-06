package com.example.project_1.data

import android.content.Context
import com.example.project_1.model.Player
import com.example.project_1.R

class PlayerDataSource(val context: Context) {

    fun getNames():Array<String>{
        return context.resources.getStringArray(R.array.name_array)
    }

    fun getPPG():Array<String>{
        return context.resources.getStringArray(R.array.ppg_array)
    }
    fun getAPG():Array<String>{
        return context.resources.getStringArray(R.array.apg_array)
    }
    fun getRPG():Array<String>{
        return context.resources.getStringArray(R.array.rpg_array)
    }

    fun loadPlayers() : List<Player>{
        val players = mutableListOf<Player>()
        val nameList = getNames()
        val ppgs = getPPG()
        val apgs = getAPG()
        val rpgs = getRPG()

        for(i in 0..29){
            val player = Player(nameList[i],ppgs[i],apgs[i],rpgs[i])
            players.add(player)
        }
        return players
    }
}