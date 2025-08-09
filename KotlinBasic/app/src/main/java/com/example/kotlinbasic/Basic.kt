package com.example.kotlinbasic

import java.util.Locale

fun main(){
    // 1. integer
    //val -> for const if never changes (Kotlin recommendation for all variables)
    //var -> for variables
    var age : Byte = 35
    println(age)
    age = 40
    println(age)

    //2. double and float
    var pi = 3.14f
    println(pi)
    pi = 3.1415926535f
    println(pi)

    //unsigned int types 0-255 -> positive direction
    var userAge : UShort = 30u
    println(userAge)
    userAge = 42u
    println(userAge)

    //3. Boolean
    val myTrue : Boolean = true
    val myFalse : Boolean = false
    println(myTrue || myFalse)
    println(myTrue && myFalse)
    println(!myTrue)

    //4. char -> use single quotes for char
    val letter = 'f'
    println(letter)
    val micro = '\u00B5'
    println(micro)

    //5. strings -> use double quotes for strings
    val text = "texts"
    println(text.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() })

    //6. if else statements
    val ages = 40
    if (ages == 42){
        println(true)
    }else{
        println(false)
    }


    //user input
    println("Insert your age:")
    val input = readln().toInt()
    if (input == 40){
        println(input)
    }else{
        println(false)
    }
println("End")











}






