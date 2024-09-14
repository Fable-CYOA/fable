package com.fable.entity

/**
 * Denotes an object that holds references to a subset of entities from a host.
 */
interface EntityContainer {

    /**
     * The host of the entities in this container, which is used to populate and remove them from [entities].
     */
    val host: EntityHost

    /**
     * The set of [Entity] that this object contains.
     */
    val entities: Set<Entity>

    /**
     * Adds a new [Entity] to the object. The entity MUST already exist in [host]. TODO duplicate handling
     */
    fun addEntity(entity: Entity)

    /**
     * Removes an existing [Entity] from the object. If the entity did not exist, this is a no-op.
     */
    fun removeEntity(entity: Entity)
}

class DefaultEntityContainer(
    override val host: EntityHost
) : EntityContainer {

    override val entities = mutableSetOf<Entity>()

    override fun addEntity(entity: Entity) {
        require(host.entities.contains(entity))
        entities.add(entity)
    }

    override fun removeEntity(entity: Entity) {
        entities.remove(entity)
    }
}

inline fun <reified T : Entity> EntityContainer.addEntity() {
    host.requireEntity<T>().also {
        addEntity(it)
    }
}

inline fun <reified T : Entity> EntityContainer.removeEntity() {
    host.requireEntity<T>().also {
        removeEntity(it)
    }
}
