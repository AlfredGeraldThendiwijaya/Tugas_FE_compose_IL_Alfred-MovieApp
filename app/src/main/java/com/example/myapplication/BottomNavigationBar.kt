package com.example.myapplication

import FavoriteScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.screens.DetailScreen
import com.example.myapplication.screens.HomeScreen
import com.example.myapplication.screens.ProfileScreen


@Composable
fun BottomNavigationBar() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                BottomNavigationItem().bottomNavigationItems().forEachIndexed { _, navigationItem ->
                    NavigationBarItem(
                        selected = navigationItem.route == currentDestination?.route,
                        label = {
                            Text(navigationItem.label)
                        },
                        icon = {
                            Icon(
                                navigationItem.icon,
                                contentDescription = navigationItem.label
                            )
                        },
                        onClick = {
                            navController.navigate(navigationItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) {paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.Home.route,
            modifier = Modifier.padding(paddingValues = paddingValues)) {
            composable(Screens.Home.route) {
              HomeScreen(
                  navController
              )
            }
            composable(Screens.Favorite.route) {
               FavoriteScreen(
                   navController
               )
            }
            composable(Screens.Profile.route) {
                ProfileScreen(
                    navController
                )
            }
            composable("detail/{filmTitle}/{filmSinopsis}/{imageResources}") { backStackEntry ->
                val filmTitle = backStackEntry.arguments?.getString("filmTitle")
                val filmSinopsis = backStackEntry.arguments?.getString("filmSinopsis")
                val imageResources = backStackEntry.arguments?.getString("imageResources")?.toIntOrNull()
                if (filmTitle != null && filmSinopsis != null && imageResources != null) {
                    DetailScreen(filmTitle,filmSinopsis, imageResources,navController)
                }
            }
        }
    }
}
