package com.example.wishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Wish")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "title")
    val title: String = "",
    @ColumnInfo(name = "description")
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
    )
}
