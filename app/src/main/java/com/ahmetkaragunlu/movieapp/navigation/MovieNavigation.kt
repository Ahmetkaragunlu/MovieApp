package com.ahmetkaragunlu.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ahmetkaragunlu.movieapp.screens.DetailScreen
import com.ahmetkaragunlu.movieapp.screens.HomeScreen


@Composable
fun MovieNavigation() {

    val navController= rememberNavController()

    NavHost(navController=navController, startDestination = MovieScreen.HOMESCREEN.route) {
        composable(route = MovieScreen.HOMESCREEN.route) {
            HomeScreen(navController = navController)
        }
        composable(route = "${MovieScreen.DETAILSCREEN.route}/{movieId}",
            arguments = listOf(navArgument("movieId"){type= NavType.IntType}
        ) ){ backStackEntry->
            run {
                val movieId = backStackEntry.arguments?.getInt("movieId")
                DetailScreen(navController=navController, movieId = movieId)

            }
        }
    }
}