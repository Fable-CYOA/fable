package com.cyoa

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember

@Composable
fun World(
    worldState: WorldState = remember { WorldState() },
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalWorldState provides worldState,
        LocalEntities provides worldState
    ) {
        content()
    }
}
