package com.example.listsandobjects



fun main(){

    //immutable list - you can't add items after the initialization
    //val shoppingList = listOf("Processor", "RAM", "GC", "SSD")

    //mutable list - you can add items after the initialization
    val shoppingList = mutableListOf("Processor", "RAM", "GC", "SSD")
    shoppingList.add("Cooling system")
    shoppingList.remove("GC")
    shoppingList.add("GC RTX 4090")

    println(shoppingList)

    shoppingList.removeAt(2)
    println(shoppingList)

    shoppingList.add(2, "Motherboard")
    println(shoppingList)


    //modify list items
    println(shoppingList[2])
    shoppingList[3] = "GC RX 7800XT"
    println(shoppingList)

    shoppingList.set(0, "Cooling system")
    println(shoppingList)

    val contains = shoppingList.contains("Cooling system")
    if (contains) println("In the list") else println("Not in the list")

    println("For loop:")
    for (item in shoppingList){
        println(item)
        if (item == "RAM") break
    }




}

