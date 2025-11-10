package com.genesis.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.google.firebase.auth.FirebaseAuth

@Composable
fun AppNavHost(
    navController: NavHostController,
    navigationProviders: Set<NavigationProvider>
) {
    val startDestination = if (FirebaseAuth.getInstance().currentUser != null) {
        Routes.Home.route
    } else {
        Routes.Login.route
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        navigationProviders.forEach {
            it.registerGraph(navController, this)
        }
    }
}