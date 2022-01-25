package com.ukejee.lushandroidtaskapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ukejee.lushandroidtaskapplication.feature.launch.LaunchListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savedInstanceState ?: addFragment()
    }

    fun addFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, LaunchListFragment())
        transaction.commit()
    }
}