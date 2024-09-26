package com.example.mobileapp_plusroom

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.bottom_home
        bottomNavigationView.setOnItemSelectedListener { item ->
            val currentActivity = this.javaClass
            val targetActivity = when (item.itemId) {
                R.id.bottom_home -> WelcomeActivity::class.java
                R.id.bottom_profile -> ProfileActivity::class.java
                R.id.bottom_search -> SearchActivity::class.java
                R.id.bottom_chat -> SendMessageActivity::class.java
                R.id.bottom_add -> CreatePostActivity::class.java
                else -> return@setOnItemSelectedListener false
            }

            if (currentActivity != targetActivity) {
                startActivity(Intent(this, targetActivity))
            }
            true
        }
        val ProfileButton = findViewById<Button>(R.id.button)
        ProfileButton.setOnClickListener {
            val intent = Intent(
                this@WelcomeActivity,
                ProfileActivity::class.java
            )
            startActivity(intent)
        }
        }

}