package com.example.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeScreen(
    modifier: Modifier = Modifier,
    viewState: MainViewModel.RecipeState,
    navigateToDetail:(Category) -> Unit
){
    val recipeViewModel: MainViewModel = viewModel()


    Box(modifier = modifier.fillMaxSize())
    {
        when {
            viewState.loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            viewState.error != null -> {
                Text(
                    text = "Error Occurred",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            else -> {
                // Display categories
                CategoryScreen(categories = viewState.list, navigateToDetail)
            }
        }
    }
}



@Composable
fun CategoryScreen(
    categories: List<Category>,
    navigateToDetail:(Category) -> Unit
)
{
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp))
    {
        items(categories){
            category -> CategoryItem(category = category, navigateToDetail)
        }
    }
}

//How each item looks like
@Composable
fun CategoryItem(category: Category, navigateToDetail:(Category) -> Unit) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(300.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(Color(0xFFE0E0E0))
            .clickable{
                navigateToDetail(category)
            }
    ) {
        // Background image
        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize().aspectRatio(1.7f)
        )

        // Text background - transparent
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp) // transparent height
                .align(Alignment.BottomStart)
                .background(Color.DarkGray.copy(alpha = 0.6f))
        )

        // Text position  - bottom left
        Text(
            text = category.strCategory,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 12.dp, bottom = 12.dp)
        )
    }
}