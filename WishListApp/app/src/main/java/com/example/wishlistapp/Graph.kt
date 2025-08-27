package com.example.wishlistapp

import android.content.Context
import androidx.room.Room
import com.example.wishlistapp.data.WishDataBase
import com.example.wishlistapp.data.WishRepository

object Graph { //object Graph == singleton and it can't be other singleton object in the app
    lateinit var dataBase: WishDataBase //promise to be initialized before to be accessed

    val wishRepository by lazy { //lazy == initialized only when first accessed
        WishRepository(wishDAO = dataBase.wishDao())
    }

    fun provide(context: Context){ //create instance of the database
        dataBase = Room.databaseBuilder(
            context,
            WishDataBase::class.java,
            "wishlist.db")
            .build()
    }
}