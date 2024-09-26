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


        val btReceivedMessage: Button = findViewById(R.id.btGotoReceivedMessage)

//        btReceivedMessage.setOnClickListener {
//            val intent = Intent(this, ReceivedMessageActivity::class.java)
//            startActivity(intent)
//        }
    }
}