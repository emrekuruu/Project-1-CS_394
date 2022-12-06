package com.example.project_1.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project_1.detailActivity.PlayerDetailActivity
import com.example.project_1.model.Player
import com.example.project_1.R

class PlayerAdapter(val players : List<Player>) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

class PlayerViewHolder(val view : View) :  RecyclerView.ViewHolder(view){
    val nameView : TextView =view.findViewById(R.id.name)
    val ppg : TextView = view.findViewById(R.id.ppg)
    val rpg : TextView = view.findViewById(R.id.rpg)
    val apg : TextView = view.findViewById(R.id.apg)

    lateinit var player : Player

    init{
        view.setOnClickListener{
            val show =Intent(itemView.context,PlayerDetailActivity::class.java)
            show.putExtra(PLAYER_KEY,player)
            itemView.context.startActivity(show)
        }
    }
    companion object{val PLAYER_KEY = "PLAYER"}

    fun bind(player: Player){
        this.player = player
        nameView.text = player.name
        ppg.text = player.PPG
        rpg.text = player.RPG
        apg.text = player.APG
    }


}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.player_view,parent,false)
        return PlayerAdapter.PlayerViewHolder(layout)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player =players[position]
        holder.bind(player)
    }

    override fun getItemCount(): Int {
        return players.size
    }
}