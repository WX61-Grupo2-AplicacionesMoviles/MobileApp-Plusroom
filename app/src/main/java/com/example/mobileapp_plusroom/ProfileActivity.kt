package com.example.mobileapp_plusroom

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val customerButton = findViewById<Button>(R.id.button3)
        customerButton.setOnClickListener {
            val intent = Intent(
                this@ProfileActivity,
                PostActivity::class.java
            )
            startActivity(intent)
        }

        val postButton = findViewById<Button>(R.id.button4)
        postButton.setOnClickListener {
            val intent = Intent(
                this@ProfileActivity,
                CustomerActivity::class.java
            )
            startActivity(intent)
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)


        bottomNavigationView.setOnItemSelectedListener { item ->
            val currentActivity = this.javaClass
            val targetActivity = when (item.itemId) {
                R.id.bottom_home -> WelcomeActivity::class.java
                R.id.bottom_profile -> ProfileActivity::class.java
                else -> return@setOnItemSelectedListener false
            }

            if (currentActivity != targetActivity) {
                startActivity(Intent(this, targetActivity))
            }
            true
        }
    }
}