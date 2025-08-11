package com.example.kotlinbasic

import java.util.Locale


data class CoffeeDetails(
    val sugarCount: Int,
    val name: String,
    val size: String,
    val creamAmount: Int
)



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
    val myTrue = true
    val myFalse = false
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
    if (ages == 42) println(true) else println(false)


    //user input
    println("Insert your age:")
    val input = readln().toInt()
    if (input == 40){
        println(input)
    }else{
        println(false)
    }
    println("End")

    var userInput = readln()
    while (userInput == "1"){
        println("While loop executed")
        userInput = readln()
    }
    println("Loop is done")


    //7. Functions
    //7.1 functions without return value
    askCoffeeDetails()

    //7.2 function with return value
    println("Enter number 1")
    val num1 = readln().toInt()
    println("Enter number 2")
    val num2 = readln().toInt()

    val addResult = add(num1, num2)
    val divideResult = divide(num1, num2)

    println(addResult)
    println(divideResult)



    // Classes
    val daisy = Dog("Daisy", breed = "Poodle")
    println("${daisy.name} is a ${daisy.breed}")



    val coffeeForDenis = CoffeeDetails(0, "Dennis", "xxl", 1)
    makeCoffee(coffeeForDenis)

}






/// Functions definition
fun makeCoffee(coffeeDetails: CoffeeDetails){
    if (coffeeDetails.sugarCount == 1){
        println("Coffee with ${coffeeDetails.sugarCount} " +
                "spoon of sugar for ${coffeeDetails.name}" +
                "and cream: ${coffeeDetails.creamAmount}"
        )
    }else if(coffeeDetails.sugarCount == 0){
        println("Coffee with no sugar for ${coffeeDetails.name}" +
                "and cream: ${coffeeDetails.creamAmount}"
        )
    }else{
        println("Coffee with ${coffeeDetails.sugarCount} " +
                "spoons of sugar for ${coffeeDetails.name}" +
                "and cream: ${coffeeDetails.creamAmount}"
        )
    }
}


fun askCoffeeDetails(){
    println("Who is this coffee for?")
    val name = readln()
    println("How many pieces of sugar do you want?")
    val sugarCount = readln().toInt()
    //makeCoffee(sugarCount, name)
}


// function with return value
fun add(num1: Int, num2:Int): Int {
    val result = num1 + num2
    return result
}

fun divide(num1: Int, num2: Int): Double {
    val result : Double = (num1 / num2).toDouble()
    return result
}
