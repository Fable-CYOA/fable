package com.fable.entity

interface EntityContainer {

    val entities: Set<Entity>

    fun addEntity(entity: Entity)

    fun removeEntity(entity: Entity)
}

class DefaultEntityContainer : EntityContainer {
    override val entities: MutableSet<Entity> = mutableSetOf()

    override fun addEntity(entity: Entity) {
        entities.add(entity)
    }

    override fun removeEntity(entity: Entity) {
        entities.remove(entity)
    }
}

inline fun <reified T : Entity> EntityContainer.findEntity(): T? {
    return entities.filterIsInstance<T>().firstOrNull()
}

inline fun <reified T : Entity> EntityContainer.requireEntity(): T {
    return entities.filterIsInstance<T>().first()
}
