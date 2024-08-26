package com.example.dicegame

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random


@Preview(showBackground = true)
@Composable
fun DiceGameScreen(modifier: Modifier = Modifier, innerPadding: PaddingValues = PaddingValues()){


    val scorePlayer1 = remember {
        mutableStateOf(0)
    }
    val scorePlayer2 = remember {
        mutableStateOf(0)
    }

    var isPlayer1Turn = remember {
        mutableStateOf(true)
    }

    var currentImg = remember {
        mutableStateOf(0 )
    }

    var image = listOf(
        R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3,
        R.drawable.dice_4,
        R.drawable.dice_5,
        R.drawable.dice_6,
    )

    if (scorePlayer1.value >= 20 || scorePlayer2.value >= 20){

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ){
            if (scorePlayer1.value > scorePlayer2.value){

                Column {
                    Row {
                        Text(text = "Player 1 Won", modifier = Modifier.padding(16.dp), fontSize = 24.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                        Button(onClick = {
                            scorePlayer1.value = 0
                            scorePlayer2.value = 0
                            currentImg.value = 0
                            isPlayer1Turn = mutableStateOf(true)
                        }) {
                            Text(text = "Play Again")
                        }
                    }
                }



            } else {
                Column {
                    Row {
                        Text(text = "Player 2 Won",modifier = Modifier.padding(16.dp), fontSize = 24.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                        Button(onClick = {
                            scorePlayer1.value = 0
                            scorePlayer2.value = 0
                            currentImg.value = 0
                            isPlayer1Turn = mutableStateOf(true)
                        }) {
                            Text(text = "Play Again")
                        }
                    }
                }

            }


        }




    }else{

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (isPlayer1Turn.value){
            Text(text = "Player 1 Turn", modifier = Modifier.padding(16.dp), fontSize = 24.sp, color = Color.Black, fontWeight = FontWeight.Bold)

        } else {
            Text(text = "Player 2 Turn",modifier = Modifier.padding(16.dp), fontSize = 24.sp, color = Color.Black, fontWeight = FontWeight.Bold)
        }




        Image(
            painter = if (currentImg.value == 0){
            painterResource(R.drawable.dice_)
        } else painterResource(image.get(currentImg.value - 1)), contentDescription = null
        )
        
        Row (modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
            Button(onClick = {
                val random = Random.nextInt(6) + 1
                currentImg.value  = random
                scorePlayer1.value += random

                isPlayer1Turn.value = !isPlayer1Turn.value
            },
                enabled = if (isPlayer1Turn.value) true else false,
                modifier = Modifier.padding(16.dp))
            {
                Text(text = "Player 1")
            }



            Button(onClick = {

                val random = Random.nextInt(6) + 1
                currentImg.value  = random
                scorePlayer2.value += random

                isPlayer1Turn.value = !isPlayer1Turn.value
            },
                enabled = if (isPlayer1Turn.value) false else true) {
                Text(text = "Player 2")
            }
        }

        Text(text = "Player 1\t\tScore: ${scorePlayer1.value}", modifier = Modifier.padding(16.dp), fontWeight = FontWeight.Bold, fontSize = 24.sp)
        Text(text = "Player 2\t\tScore: ${scorePlayer2.value}", modifier = Modifier.padding(16.dp), fontWeight = FontWeight.Bold, fontSize = 24.sp)

    }
}
}