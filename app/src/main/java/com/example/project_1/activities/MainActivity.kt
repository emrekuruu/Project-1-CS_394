package com.example.project_1.Activities

import PlayerFragment
import TeamFragment
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentContainer
import com.example.project_1.R
import com.example.project_1.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playerFragment = PlayerFragment()
        val teamFragment = TeamFragment()
        val homeFragment = HomeFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView,homeFragment)
            commit()
        }

        val menu : BottomNavigationView = findViewById(R.id.bottomNav)

        menu.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.HomePage ->
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView,homeFragment)
                        commit()
                    }
                R.id.teamslogo ->      supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragmentContainerView,teamFragment)
                    commit()
                }
                R.id.playerlogo ->      supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragmentContainerView,playerFragment)
                    commit()
                }
            }
            true
        }

    }
}