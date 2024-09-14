package com.cyoa

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun Entity(
    entity: Entity,
    content: @Composable EntityScope.() -> Unit
) {
    val scope = remember(entity) { EntityScope(entity) }
    content(scope)
}

class EntityScope(val entity: Entity) {
    @Composable
    inline fun <reified T: Event<*>> rememberEvent(): T? {
        return remember(entity.events) {
            entity.findEvent<T>()
        }
    }
}
