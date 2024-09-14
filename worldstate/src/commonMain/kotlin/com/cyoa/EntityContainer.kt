package com.cyoa

abstract class EntityContainer {

    val entities = mutableListOf<Entity>()

    inline fun <reified T : Entity> findEntity(): T? {
        return entities.filterIsInstance<T>().firstOrNull()
    }

    open fun addEntity(entity: Entity) {
        entities.add(entity)
    }

    open fun removeEntity(entity: Entity) {
        entities.remove(entity)
    }
}
