package com.example.bottomnavigationbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)

        openFragment(MyHomeFragment())

        bottomNav.setOnNavigationItemSelectedListener {
            val id = it.itemId
            when(id){
                R.id.Home -> {
                    openFragment(MyHomeFragment())
                }
                R.id.Profile -> {
                    openFragment(MyProfileFragment())
                }
                R.id.Cart -> {
                    openFragment(MyCartFragment())
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
    private fun openFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcb,fragment)
            .commit()
    }
}