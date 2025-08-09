package com.example.rockpaperscissors

import androidx.collection.emptyLongSet

fun main(){

    var computerChoice = ""
    var userChoice = ""

    println("Rock, Paper or Scissors?")
    userChoice = readln()

    val randomNumber = (1..3).random()

    when (randomNumber) {
        1 -> {
            computerChoice = "Rock"
        }
        2 -> {
            computerChoice = "Paper"
        }
        3 -> {
            computerChoice = "Scissors"
        }
    }

    val winner = when{
        userChoice == computerChoice -> "Tie"
        userChoice == "Rock" && computerChoice == "Scissors" -> "Player"
        userChoice == "Paper" && computerChoice == "Rock" -> "Player"
        userChoice == "Scissors" && computerChoice == "Paper" -> "Player"
        else -> "Computer"
    }

    if (winner == "Tie"){
        println("Tie")
    }else {
        println("$winner won!!")
    }

    println(computerChoice)



}