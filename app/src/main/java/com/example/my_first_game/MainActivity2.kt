package com.example.my_first_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button:Button = findViewById(R.id.button)
        val quit_Button:Button = findViewById(R.id.quit_Button)
        val go_Back_Button:Button = findViewById(R.id.Go_back_to_menu)

        button.setOnClickListener {
            val Intent = Intent(this,MainActivity::class.java)
            startActivity(Intent)
        }
        quit_Button.setOnClickListener {
            /*finish()
            System.out.close()*/
            this.finishAffinity();//close every activity
            //android.os.Process.killProcess(android.os.Process.myPid())
        }
        go_Back_Button.setOnClickListener {
            val Intent = Intent(this,MainMenu::class.java)
            startActivity(Intent)
        }
    }
}