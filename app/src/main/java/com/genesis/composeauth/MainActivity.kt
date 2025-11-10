package com.genesis.composeauth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.genesis.core.navigation.AppNavHost
import com.genesis.core.ui.composables.NoInternetScreen
import com.genesis.core.ui.theme.ComposeAuthTheme
import com.genesis.core.utils.NetworkObserver
import com.genesis.feature_auth.navigation.AuthNavigationProvider
import com.genesis.feature_home.navigation.HomeNavigationProvider

class MainActivity : ComponentActivity() {

    private lateinit var networkObserver: NetworkObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkObserver = NetworkObserver(applicationContext)
        // Enable edge-to-edge display to draw behind the system bars
        enableEdgeToEdge()
        setContent {
            val isConnected by networkObserver.observe().collectAsState(initial = true)
            // Your custom theme, likely named ComposeAuthTheme based on project structure
            ComposeAuthTheme {
                if (isConnected) {
                    val navController = rememberNavController()
                    AppNavHost(
                        navController = navController,
                        navigationProviders = setOf(
                            AuthNavigationProvider(),
                            HomeNavigationProvider()
                        )
                    )
                } else {
                    NoInternetScreen()
                }
            }
        }
    }
}
