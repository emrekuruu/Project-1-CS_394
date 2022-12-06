package com.example.project_1.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.project_1.R
import com.example.project_1.adapter.PlayerAdapter
import com.example.project_1.adapter.TeamAdapter
import com.example.project_1.data.PlayerDataSource
import com.example.project_1.data.TeamDataSource
import com.google.android.material.bottomnavigation.BottomNavigationView

class PlayersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players)


        val menu : BottomNavigationView = findViewById(R.id.playersBottomNav)
        val recyclerView : RecyclerView = findViewById(R.id.playersRecyclerView)
        val players= PlayerDataSource(this).loadPlayers()
        recyclerView.adapter = PlayerAdapter(players)

        menu.selectedItemId = R.id.playerlogo


        menu.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.teamslogo -> Intent(this,TeamsActivity::class.java).also{startActivity(it)}
                R.id.HomePage -> Intent(this,MainActivity::class.java).also{startActivity(it)}
                else -> {}
            }
            true
        }

    }
}