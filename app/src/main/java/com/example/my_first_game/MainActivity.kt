package com.example.my_first_game

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    var player = true
    var getInfo:Boolean = isAI
    var rounds = 0
    var choosen = arrayOf(-2,-2,-2,-2, -2, -2, -2, -2, -2)
    var isTaken1:IntArray = intArrayOf(-1,-1,-1,-1, -1, -1, -1, -1, -1)
    var isTaken2:IntArray = intArrayOf(0, 0, 0 , 0, 0, 0, 0, 0, 0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        val first_Button: ImageButton = findViewById(R.id.imageButton)
        val second_Button: ImageButton = findViewById(R.id.imageButton4)
        val third_Button: ImageButton = findViewById(R.id.imageButton3)
        val fourth_Button: ImageButton = findViewById(R.id.imageButton9)
        val fith_Button: ImageButton = findViewById(R.id.imageButton10)
        val six_Button: ImageButton = findViewById(R.id.imageButton8)
        val seven_Button: ImageButton = findViewById(R.id.imageButton12)
        val eigth_Button: ImageButton = findViewById(R.id.imageButton13)
        val nine_Button: ImageButton = findViewById(R.id.imageButton11)

        fun Ai():Int
        {
            //dosent work
            var random = (1..9).random()
            return random
        }
        fun CheckWin(isWin:IntArray)
        {
            if (isWin[0] == 1 && isWin[1] == 2 && isWin[2] == 3) {
                startActivity(Intent(this,MainActivity2::class.java))
            }
            else if(isWin[3] == 4 && isWin[4] == 5 && isWin[5] == 6){
                startActivity(Intent(this,MainActivity2::class.java))
            }
            else if(isWin[6] == 7 && isWin[7] == 8 && isWin[8] == 9)
            {
                startActivity(Intent(this,MainActivity2::class.java))
            }
            else if(isWin[0] == 1 && isWin[3] == 4 && isWin[6] == 7)
            {
                startActivity(Intent(this,MainActivity2::class.java))
            }
            else if(isWin[1] == 2 && isWin[4] == 5 && isWin[7] == 8)
            {
                startActivity(Intent(this,MainActivity2::class.java))
            }
            else if(isWin[2] == 3 && isWin[5] == 6 && isWin[8] == 9)
            {
                startActivity(Intent(this,MainActivity2::class.java))
            }
            else if(isWin[0] == 1 && isWin[4] == 5 && isWin[8] == 9)
            {
                startActivity(Intent(this,MainActivity2::class.java))
            }
            else if(isWin[2] == 3 && isWin[4] == 5 && isWin[6] == 7)
            {
                startActivity(Intent(this,MainActivity2::class.java))
            }
            else if(rounds == 9) {
                startActivity(Intent(this,MainActivity2::class.java))
            }

        }

        fun Dicition(num:Int)
        {
            var num2 = num//num is a constant
            //Positions of the x and 0
            for(i in 0..8)
            {
                if(num2 == choosen[i])
                {
                    num2 = 0
                    break
                }

            }
            if(player)
            {
                when(num2)
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
                when(num2)
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
            choosen[num-1] = num

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
            if(num2!=0)
            {
                player = !player
                rounds+=1
            }
            CheckWin(isTaken1)
            CheckWin(isTaken2)

        }
        fun AiDicision()
        {
            if(!player && rounds < 9)
            {
                var num2 = 0 //num is a constant
                var limit:Int = 0
                do
                {
                    var reach = 0
                    num2 = Ai()
                    limit = 1
                    for(i in 0..8)
                    {
                        if(num2 == choosen[i])
                        {
                            limit = 0
                            reach++
                        }
                    }
                    if(reach == 9)
                    {
                        limit = 1
                    }

                }while (limit == 0)
                when(num2)
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
                choosen[num2-1] = num2

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
                player = !player
                rounds+=1
                CheckWin(isTaken2)
            }
        }

        fun AiTurn()
        {
            if (getInfo)
            {
                AiDicision()
            }
        }

        var number:Int = 0
        first_Button.setOnClickListener {
            number = 1
            Dicition(number)
            AiTurn()
        }
        second_Button.setOnClickListener {
            number = 2
            Dicition(number)
            AiTurn()

        }
        third_Button.setOnClickListener {
            number = 3
            Dicition(number)
            AiTurn()

        }
        fourth_Button.setOnClickListener {
            number = 4
            Dicition(number)
            AiTurn()
        }
        fith_Button.setOnClickListener {
            number = 5
            Dicition(number)
            AiTurn()
        }
        six_Button.setOnClickListener {
            number = 6
            Dicition(number)
            AiTurn()
        }
        seven_Button.setOnClickListener {
            number = 7
            Dicition(number)
            AiTurn()
        }
        eigth_Button.setOnClickListener {
            number = 8
            Dicition(number)
            AiTurn()
        }
        nine_Button.setOnClickListener {
            number = 9
            Dicition(number)
            AiTurn()
        }

    }
}

/*@Composable
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
}*/