package com.genesis.composeauth.ui.theme

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.concurrent.ConcurrentHashMap

// A thread-safe cache to store the resolved resource IDs.
// This avoids expensive lookups on every recomposition.
private val sdpIdCache = ConcurrentHashMap<Int, Int>()
private val sspIdCache = ConcurrentHashMap<Int, Int>()

/**
 * Converts an integer to a scalable DP (sdp) value.
 *
 * This function looks up a dimension resource from the sdp library (e.g., "_16sdp")
 * and returns it as a [androidx.compose.ui.unit.Dp] type for Jetpack Compose.
 *
 * The result of the resource ID lookup is cached for performance, so the expensive
 * `getIdentifier` call only runs once for each unique dimension value.
 *
 * @return The [androidx.compose.ui.unit.Dp] value, or `0.dp` if the resource is not found.
 */
@Composable
fun Int.sdp(): Dp {
    val context = LocalContext.current
    val resourceId = remember(this, context) {
        sdpIdCache.getOrPut(this) {
            getDimensionResourceId("_${this}sdp", context)
        }
    }

    return if (resourceId != 0) dimensionResource(id = resourceId) else 0.dp
}

/**
 * Converts an integer to a scalable SP (ssp) value.
 *
 * This function looks up a dimension resource from the ssp library (e.g., "_12ssp")
 * and returns it as a [androidx.compose.ui.unit.TextUnit] type for Jetpack Compose.
 *
 * The result of the resource ID lookup is cached for performance, so the expensive
 * `getIdentifier` call only runs once for each unique dimension value.
 *
 * @return The [androidx.compose.ui.unit.TextUnit] value, or `0.sp` if the resource is not found.
 */
@Composable
fun Int.ssp(): TextUnit {
    val context = LocalContext.current
    val resourceId = remember(this, context) {
        sspIdCache.getOrPut(this) {
            getDimensionResourceId("_${this}ssp", context)
        }
    }

    return if (resourceId != 0) dimensionResource(id = resourceId).value.sp else 0.sp
}

/**
 * A helper function to safely retrieve a dimension resource ID by its string name.
 *
 * @param name The name of the dimension resource (e.g., "_16sdp").
 * @param context The application context.
 * @return The integer resource ID, or `0` if not found.
 */
private fun getDimensionResourceId(name: String, context: Context): Int {
    // This is an expensive reflection-based call and should be used sparingly.
    // Caching the result is highly recommended.
    return context.resources.getIdentifier(name, "dimen", context.packageName)
}