package com.example.wishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wishlistapp.data.Wish
import com.example.wishlistapp.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
            private val wishRepository: WishRepository = Graph.wishRepository
    ) : ViewModel() {
    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun onWishTitleChanged(newString: String){
        wishTitleState = newString
    }

    fun onWishDescriptionChanged(newString: String){
        wishDescriptionState = newString
    }


    lateinit var gelAllWishes: Flow<List<Wish>>

    init {
        viewModelScope.launch { gelAllWishes = wishRepository.getWishes() }
    }

    fun addWish(wish: Wish){ //Dispatchers.IO -> input - output (for database tasks run smoothly)
        viewModelScope.launch(Dispatchers.IO) { wishRepository.addWish(wish) }
    }

    fun updateWish(wish: Wish){ //Dispatchers.IO -> input - output (for database tasks run smoothly)
        viewModelScope.launch(Dispatchers.IO) { wishRepository.updateWish(wish) }
    }

    fun getWishById(id: Long): Flow<Wish> {
        return wishRepository.getWishById(id)
    }

    fun deleteWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO){ wishRepository.deleteWish(wish) }
    }

}