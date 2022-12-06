package com.example.project_1.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.project_1.R
import com.example.project_1.adapter.TeamAdapter
import com.example.project_1.data.PlayerDataSource
import com.example.project_1.data.TeamDataSource
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menu : BottomNavigationView = findViewById(R.id.bottomNav)

        menu.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.teamslogo -> Intent(this,TeamsActivity::class.java).also{startActivity(it)}
                R.id.playerlogo -> Intent(this,PlayersActivity::class.java).also{startActivity(it)}
                else -> {}
            }
            true
        }

    }
}