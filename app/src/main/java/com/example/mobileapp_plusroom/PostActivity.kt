package com.example.mobileapp_plusroom

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class PostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_post)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val viewAuthorProfile: Button = findViewById(R.id.btViewAuthorProfile)

        bottomNavigationView.setOnItemSelectedListener { item ->
            val currentActivity = this.javaClass
            val targetActivity = when (item.itemId) {
                R.id.bottom_home -> WelcomeActivity::class.java
                R.id.bottom_profile -> ProfileActivity::class.java
                R.id.bottom_search -> SearchActivity::class.java
                R.id.bottom_add -> CreatePostActivity::class.java
                R.id.bottom_chat -> SendMessageActivity::class.java
                else -> return@setOnItemSelectedListener false
            }
//        viewAuthorProfile.setOnClickListener {
//            val intent = Intent(this, AuthorProfileActivity::class.java)
//            startActivity(intent)
//        }

            if (currentActivity != targetActivity) {
                startActivity(Intent(this, targetActivity))
            }
            true
        }
    }
}