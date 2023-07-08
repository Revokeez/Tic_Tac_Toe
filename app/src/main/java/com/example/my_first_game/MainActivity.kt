package com.example.my_first_game

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.my_first_game.ui.theme.My_First_GameTheme
class MainActivity : ComponentActivity() {
    var player = true
    var isWin1 = arrayOf(-1,-1,-1,-1, -1, -1, -1, -1, -1)
    var isTaken1:IntArray = intArrayOf(-1,-1,-1,-1, -1, -1, -1, -1, -1)
    var isTaken2:IntArray = intArrayOf(0, 0, 0 , 0, 0, 0, 0, 0, 0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        val getText: TextView = findViewById(R.id.textView)
        val first_Button: ImageButton = findViewById(R.id.imageButton)
        val second_Button: ImageButton = findViewById(R.id.imageButton4)
        val third_Button: ImageButton = findViewById(R.id.imageButton3)
        val fourth_Button: ImageButton = findViewById(R.id.imageButton9)
        val fith_Button: ImageButton = findViewById(R.id.imageButton10)
        val six_Button: ImageButton = findViewById(R.id.imageButton8)
        val seven_Button: ImageButton = findViewById(R.id.imageButton12)
        val eigth_Button: ImageButton = findViewById(R.id.imageButton13)
        val nine_Button: ImageButton = findViewById(R.id.imageButton11)


        fun CheckWin(isWin1:IntArray)
        {
            if (isWin1[0] == 1 && isWin1[1] == 2 && isWin1[2] == 3) {
                getText.setText("You won still in testing")
            }
            else if(isWin1[3] == 4 && isWin1[4] == 5 && isWin1[5] == 6){
                getText.setText("You won still in testing")
            }
            else if(isWin1[6] == 7 && isWin1[7] == 8 && isWin1[8] == 9)
            {
                getText.setText("You won still in testing")
            }
            else if(isWin1[0] == 1 && isWin1[3] == 4 && isWin1[6] == 7)
            {
                getText.setText("You won still in testing")
            }
            else if(isWin1[1] == 2 && isWin1[4] == 5 && isWin1[7] == 8)
            {
                getText.setText("You won still in testing")
            }
            else if(isWin1[2] == 3 && isWin1[5] == 6 && isWin1[8] == 9)
            {
                getText.setText("You won still in testing")
            }
            else if(isWin1[0] == 1 && isWin1[4] == 5 && isWin1[8] == 9)
            {
                getText.setText("You won still in testing")
            }
            else if(isWin1[2] == 3 && isWin1[4] == 5 && isWin1[6] == 7)
            {
                getText.setText("You won still in testing")
            }

        }

        fun Dicition(num:Int)
        {
            if(player)
            {
                when(num)
                {
                    1 -> isTaken1[0] = 1
                    2 -> isTaken1[1] = 2
                    3 -> isTaken1[2] = 3
                    4 -> isTaken1[3] = 4
                    5 -> isTaken1[4] = 5
                    6 -> isTaken1[5] = 6
                    7 -> isTaken1[6] = 7
                    8 -> isTaken1[7] = 8
                    9 -> isTaken1[8] = 9
                }

            }
            else {
                when(num)
                {
                    1 -> isTaken2[0] = 1
                    2 -> isTaken2[1] = 2
                    3 -> isTaken2[2] = 3
                    4 -> isTaken2[3] = 4
                    5 -> isTaken2[4] = 5
                    6 -> isTaken2[5] = 6
                    7 -> isTaken2[6] = 7
                    8 -> isTaken2[7] = 8
                    9 -> isTaken2[8] = 9
                }

            }
            var num2 = num
            for (i in 0..8)
            {
                if(player)
                {
                    if (isTaken1[i] == isTaken2[i]) {
                        isTaken1[i] = -1
                        num2 = 0
                        player = !player
                    }
                }
                else
                {
                    if (isTaken1[i] == isTaken2[i]) {
                        isTaken2[i] = 0
                        num2 = 0
                        player = !player
                    }
                }

            }
            if(player)
            {
                when(num2)
                {
                    1 -> first_Button.setImageResource(R.drawable.o_image)
                    2 -> second_Button.setImageResource(R.drawable.o_image)
                    3 -> third_Button.setImageResource(R.drawable.o_image)
                    4 -> fourth_Button.setImageResource(R.drawable.o_image)
                    5 -> fith_Button.setImageResource(R.drawable.o_image)
                    6 -> six_Button.setImageResource(R.drawable.o_image)
                    7 -> seven_Button.setImageResource(R.drawable.o_image)
                    8 -> eigth_Button.setImageResource(R.drawable.o_image)
                    9 -> nine_Button.setImageResource(R.drawable.o_image)
                }
            }
            else
            {
                when(num2)
                {
                    1 -> first_Button.setImageResource(R.drawable.x_image)
                    2 -> second_Button.setImageResource(R.drawable.x_image)
                    3 -> third_Button.setImageResource(R.drawable.x_image)
                    4 -> fourth_Button.setImageResource(R.drawable.x_image)
                    5 -> fith_Button.setImageResource(R.drawable.x_image)
                    6 -> six_Button.setImageResource(R.drawable.x_image)
                    7 -> seven_Button.setImageResource(R.drawable.x_image)
                    8 -> eigth_Button.setImageResource(R.drawable.x_image)
                    9 -> nine_Button.setImageResource(R.drawable.x_image)
                }
            }


            player = !player
            CheckWin(isTaken1)
            CheckWin(isTaken2)
        }
        var number:Int = 0
        first_Button.setOnClickListener {
            number = 1
            Dicition(number)
        }
        second_Button.setOnClickListener {
            number = 2
            Dicition(number)

        }
        third_Button.setOnClickListener {
            number = 3
            Dicition(number)

        }
        fourth_Button.setOnClickListener {
            number = 4
            Dicition(number)
        }
        fith_Button.setOnClickListener {
            number = 5
            Dicition(number)
        }
        six_Button.setOnClickListener {
            number = 6
            Dicition(number)

        }
        seven_Button.setOnClickListener {
            number = 7
            Dicition(number)

        }
        eigth_Button.setOnClickListener {
            number = 8
            Dicition(number)

        }
        nine_Button.setOnClickListener {
            number = 9
            Dicition(number)
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    My_First_GameTheme {
        Greeting("Android")
    }
}