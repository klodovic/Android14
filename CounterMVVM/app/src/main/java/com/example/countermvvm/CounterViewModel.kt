package com.example.countermvvm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel(){

    private val _count = mutableIntStateOf(0)

    //expose the count as an immutable state
    val count: State<Int> = _count

    fun increment(){
        _count.intValue ++
    }

    fun decrement(){
        _count.intValue --
    }

}