package com.genesis.composeauth.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.genesis.feature_auth.ui.login.LoginScreen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun AppNavHost(navController: NavHostController) {
    val startDestination = if (FirebaseAuth.getInstance().currentUser != null) {
        Routes.Home.route
    } else {
        Routes.Login.route
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Routes.Login.route) {
            LoginScreen(navController = navController)
        }

        /*composable(Routes.Register.route) {
            RegisterScreen(navController = navController)
        }

        composable(Routes.Home.route) {
            HomeScreen(navController = navController)
        }*/
    }
}