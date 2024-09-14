package com.fable.entity

/**
 * Denotes an object that "hosts" entities. To host an entity is to hold its state, being the source of truth for the
 * entity.
 */
interface EntityHost {

    /**
     * The set of [Entity] that this object hosts.
     */
    val entities: Set<Entity>

    /**
     * Adds a new [Entity] to the object. TODO duplicate handling
     */
    fun addEntity(entity: Entity)

    /**
     * Removes an existing [Entity] from the object. If the entity did not exist, this is a no-op.
     */
    fun removeEntity(entity: Entity)
}

class DefaultEntityHost : EntityHost {
    override val entities: MutableSet<Entity> = mutableSetOf()

    override fun addEntity(entity: Entity) {
        entities.add(entity)
    }

    override fun removeEntity(entity: Entity) {
        entities.remove(entity)
    }
}

inline fun <reified T : Entity> EntityHost.findEntity(): T? {
    return entities.filterIsInstance<T>().firstOrNull()
}

inline fun <reified T : Entity> EntityHost.requireEntity(): T {
    return entities.filterIsInstance<T>().first()
}
