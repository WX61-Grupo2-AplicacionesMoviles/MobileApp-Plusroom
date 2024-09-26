package com.example.mobileapp_plusroom

import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvCategory: TextView = findViewById(R.id.tvCategory)
        val btApartment: Button = findViewById(R.id.btApartment)
        val btRoom: Button = findViewById(R.id.btRooms)
        val btHouse: Button = findViewById(R.id.btHousing)

        fun changeVisibility() {

        }
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.bottom_search
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

            if (currentActivity != targetActivity) {
                startActivity(Intent(this, targetActivity))
            }
            true
        }
        btApartment.setOnClickListener {
            tvCategory.text = "Departamentos"
            changeVisibility()
        }
        btRoom.setOnClickListener {
            tvCategory.text = "Cuartos"
            changeVisibility()
        }
        btHouse.setOnClickListener {
            tvCategory.text = "Viviendas"
            changeVisibility()
        }

        val tvProperties: TextView = findViewById(R.id.tvPropertiesLinkView)
        val tvRoomies: TextView = findViewById(R.id.tvRoomiesLinkView)

        tvProperties.setOnClickListener {

        }
        tvRoomies.setOnClickListener {

        }

    }
}