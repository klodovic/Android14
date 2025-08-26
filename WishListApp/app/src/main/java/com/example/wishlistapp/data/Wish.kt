package com.example.wishlistapp.data

data class Wish(
    val id: Long = 0L,
    val title: String = "",
    val description: String = ""
)

object DummyWish{
    val wishList = listOf(
        Wish(title = "Google Watch 2", description = "An Android Watch"),
        Wish(title = "Xiaomi", description = "14 PRO"),
        Wish(title = "Garmin", description = "Epic pro 2"),
        Wish(title = "HP", description = "laptop"),
        Wish(title = "HP", description = "laptop"),
        Wish(title = "HP", description = "laptop"),
        Wish(title = "HP", description = "laptop"),
        Wish(title = "HP", description = "laptop"),
        Wish(title = "HP", description = "laptop"),
        Wish(title = "HP", description = "laptop"),
        Wish(title = "HP", description = "laptop"),
        Wish(title = "HP", description = "laptop"),
    )
}
