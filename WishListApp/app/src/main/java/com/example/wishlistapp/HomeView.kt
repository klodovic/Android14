package com.example.wishlistapp

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.wishlistapp.Data.Wish

@Composable
fun HomeView(modifier: Modifier){
    val context = LocalContext.current
    Scaffold(
        topBar = {AppBarView(title = "WishList")
            {
                Toast.makeText(
                    context,
                    "Button clicked",
                    Toast.LENGTH_LONG).show()
            }
        },

        floatingActionButton = {
            FloatingActionButton(
                modifier = modifier.padding(30.dp),
                contentColor = Color.White,
                backgroundColor = Color.Black,
                onClick = {
                    Toast.makeText(
                        context,
                        "FAB button clicked",
                        Toast.LENGTH_LONG).show()
                })
            {
                Icon(
                    imageVector = Icons.Default.Add, contentDescription = null
                )
            }
        }

    ) {
        LazyColumn(modifier = modifier.fillMaxSize().padding(it))
        {

        }
    }
}

@Composable
fun WishItem(modifier: Modifier, wish: Wish, onClick: () -> Unit){
    Card(
        modifier = modifier.fillMaxWidth().padding
            (
                top = 8.dp,
                start = 8.dp,
                end = 8.dp
            ).clickable{ onClick() },
        elevation = 10.dp,
        backgroundColor = Color.White
    )
    {
        Column(modifier = modifier.padding(16.dp))
        {
            Text(text = wish.title, fontWeight = FontWeight.ExtraBold)
            Text(text = wish.description)
        }
    }
}