package com.example.mobileapp_plusroom

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val loginButton = findViewById<Button>(R.id.button3)
        loginButton.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                LoginActivity::class.java
            )
            startActivity(intent)
        }
        val registerButton = findViewById<Button>(R.id.button4)
        registerButton.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                RegisterActivity::class.java
            )
            startActivity(intent)
        }
    }
}