package com.example.my_first_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
 public var isAI:Boolean = false
class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        val sPlayer:Button = findViewById(R.id.Single_Player)
        val twoPlayer:Button = findViewById(R.id.Two_Players)
        val Intent = Intent(this,MainActivity::class.java)

        sPlayer.setOnClickListener {
            isAI = false
            startActivity(Intent)
        }
        twoPlayer.setOnClickListener {
            isAI = true
            startActivity(Intent)
        }

    }
}