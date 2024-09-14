package com.cyoa

import androidx.compose.runtime.Composable

@Composable
fun Scene(
    content: @Composable SceneScope.() -> Unit,
) {

}

class SceneScope() : EntityContainer() {

}
