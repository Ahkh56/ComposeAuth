package com.genesis.composeauth.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect // 1. IMPORT SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView // 2. IMPORT LocalView
import androidx.core.view.WindowCompat // 3. IMPORT WindowCompat
import com.genesis.core.ui.theme.Pink40
import com.genesis.core.ui.theme.Pink80
import com.genesis.core.ui.theme.Purple40
import com.genesis.core.ui.theme.Purple80
import com.genesis.core.ui.theme.PurpleGrey40
import com.genesis.core.ui.theme.PurpleGrey80

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

@Composable
fun ComposeAuthTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    // THIS IS THE FIX
    // 4. ADD THIS SideEffect BLOCK
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            // This line tells the system to NOT draw content behind the system bars.
            // It effectively disables edge-to-edge for this theme.
            WindowCompat.setDecorFitsSystemWindows(window, true)
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
