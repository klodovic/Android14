package com.example.wishlistapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(
    modifier: Modifier,
    viewModel: WishViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
)
{
    NavHost(
        navController= navController,
        startDestination = Screen.HomeScreen.route
    )
    {
        composable(Screen.HomeScreen.route){
            HomeView(
                modifier = modifier,
                navController = navController,
                viewModel = viewModel
            )
        }

        composable(Screen.AddScreen.route){
            AddEditDetailView(
                modifier = modifier,
                id = 0L,
                viewModel = viewModel,
                navController = navController,
            )
        }


    }
}