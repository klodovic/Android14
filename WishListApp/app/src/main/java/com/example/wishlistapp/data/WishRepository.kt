package com.example.wishlistapp.data

import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDAO: WishDAO) {

    //1. create new wish
    suspend fun addWish(wish: Wish){
        wishDAO.addWish(wish)
    }

    //2. get all items
    fun getWishes(): Flow<List<Wish>> = wishDAO.getAllWishes()

    //3. get single item
    fun getWishById(id: Long): Flow<Wish>{
        return wishDAO.getWishById(id)
    }

    //4. update wish
    suspend fun updateWish(wish: Wish){
        wishDAO.updateWish(wish)
    }

    //5. delete wish
    suspend fun deleteWish(wish: Wish){
        wishDAO.deleteWish(wish)
    }

}