package com.example.project_1.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project_1.R
import com.example.project_1.detailActivity.TeamDetailActivity
import com.example.project_1.model.Team

class TeamAdapter(val teams : List<Team>) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    class TeamViewHolder(val view : View) :  RecyclerView.ViewHolder(view){

        val nameView : TextView = view.findViewById(R.id.teamName)
        val recordView : TextView = view.findViewById(R.id.teamRecord)


        lateinit var team : Team

        init{
            view.setOnClickListener{
                val show =Intent(itemView.context, TeamDetailActivity::class.java)
                show.putExtra(TEAM_KEY,team)
                itemView.context.startActivity(show)
            }
        }
        companion object{val TEAM_KEY = "TEAM"}

        fun bind(team: Team){
            this.team = team
            nameView.text = team.name
            recordView.text = team.record
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.team_view,parent,false)
        return TeamAdapter.TeamViewHolder(layout)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = teams[position]
        holder.bind(team)
    }

    override fun getItemCount(): Int {
        return teams.size
    }
}