package com.genesis.composeauth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.genesis.composeauth.navigation.AppNavHost
import com.genesis.composeauth.ui.theme.ComposeAuthTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Enable edge-to-edge display to draw behind the system bars
        enableEdgeToEdge()
        setContent {
            // Your custom theme, likely named ComposeAuthTheme based on project structure
            ComposeAuthTheme {
                val navController = rememberNavController()
                AppNavHost(navController = navController)
            }
        }
    }
}
