package com.genesis.feature_home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.genesis.core.navigation.NavigationProvider
import com.genesis.core.navigation.Routes
import com.genesis.feature_home.HomeScreen

class HomeNavigationProvider : NavigationProvider {
    override fun registerGraph(
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.composable(Routes.Home.route) {
            HomeScreen(navController = navController)
        }
    }
}