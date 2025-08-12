package com.example.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaptainGameTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CaptainGame(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CaptainGame(modifier: Modifier = Modifier)
{
    val treasuresFound = remember { mutableIntStateOf(0) }
    val direction = remember { mutableStateOf("North") }
    val stormOrTreasure = remember { mutableStateOf("") }


    Box(
        modifier = modifier.fillMaxSize() // Box zauzima sav prostor
        //contentAlignment = Alignment.Center // Centriraj sve unutar Box-a
    ){
        Column {

            Text("Treasures Found: ${treasuresFound.intValue}")
            Text("Current Direction: ${direction.value}")
            Text(stormOrTreasure.value)

            Button(onClick = {
                direction.value = "East"
                if (Random.nextBoolean()){
                    treasuresFound.intValue += 1
                    stormOrTreasure.value = "We found a treasure"
                }else{
                    stormOrTreasure.value = "Storm ahead!!!"
                }
            }) {
                Text("Sail East")
            }

            Button(onClick = {
                direction.value = "West"
                if (Random.nextBoolean()){
                    treasuresFound.intValue += 1
                    stormOrTreasure.value = "We found a treasure"
                }else{
                    stormOrTreasure.value = "Storm ahead!!!"
                }
            }) {
                Text("Sail West")
            }

            Button(onClick = {
                direction.value = "North"
                if (Random.nextBoolean()){
                    treasuresFound.intValue += 1
                    stormOrTreasure.value = "We found a treasure"
                }else{
                    stormOrTreasure.value = "Storm ahead!!!"
                }
            }) {
                Text("Sail North")
            }

            Button(onClick = {
                direction.value = "South"
                if (Random.nextBoolean()){
                    treasuresFound.intValue += 1
                    stormOrTreasure.value = "We found a treasure"
                }else{
                    stormOrTreasure.value = "Storm ahead!!!"
                }
            }) {
                Text("Sail South")
            }

        }
    }


}

