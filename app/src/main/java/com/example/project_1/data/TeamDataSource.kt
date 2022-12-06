package com.example.project_1.data

import android.content.Context
import com.example.project_1.model.Team
import com.example.project_1.R

class TeamDataSource(val context: Context) {

    fun getNames():Array<String>{
        return context.resources.getStringArray(R.array.team_array)
    }

    fun getRecord():Array<String>{
        return context.resources.getStringArray(R.array.record_array)
    }

    fun loadTeams():List<Team>{
        val teams = mutableListOf<Team>()
        val names = getNames()
        val records = getRecord()
        for(i in 0..5){
            val team = Team(names[i],records[i])
            teams.add(team)
        }
        return teams
    }
}