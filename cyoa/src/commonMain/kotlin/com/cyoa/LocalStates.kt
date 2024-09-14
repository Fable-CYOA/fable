package com.cyoa

import androidx.compose.runtime.compositionLocalOf

val LocalEntities = compositionLocalOf<EntityContainer> { error("No EntityContainer provided") }

val LocalWorldState = compositionLocalOf<WorldState> { error("No WorldState provided") }
