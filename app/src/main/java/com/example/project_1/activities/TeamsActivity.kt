package com.example.project_1.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.project_1.R
import com.example.project_1.adapter.TeamAdapter
import com.example.project_1.data.PlayerDataSource
import com.example.project_1.data.TeamDataSource
import com.google.android.material.bottomnavigation.BottomNavigationView

class TeamsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teams)

        val menu : BottomNavigationView = findViewById(R.id.teamsBottomNav)
        val recyclerView : RecyclerView = findViewById(R.id.teamsRecyclerView)
        val teams = TeamDataSource(this).loadTeams()
        recyclerView.adapter =TeamAdapter(teams)

        menu.selectedItemId = R.id.teamslogo

        menu.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.playerlogo -> Intent(this,PlayersActivity::class.java).also{startActivity(it)}
                R.id.HomePage -> Intent(this,MainActivity::class.java).also{startActivity(it)}
                else -> {}
            }
            true
        }
    }
}