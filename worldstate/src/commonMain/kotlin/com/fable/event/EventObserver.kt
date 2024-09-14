package com.fable.event

interface EventObserver {
    val events: Set<Event<*>>

    fun addEvent(event: Event<*>)

    fun removeEvent(event: Event<*>)
}

class DefaultEventObserver : EventObserver {
    override val events = mutableSetOf<Event<*>>()
    override fun addEvent(event: Event<*>) {
        events.add(event)
    }
    override fun removeEvent(event: Event<*>) {
        events.remove(event)
    }
}

inline fun <reified T: Event<*>> EventObserver.findEvent(): T? {
    return events.filterIsInstance<T>()
        .firstOrNull()
}

inline fun <reified T: Event<*>> EventObserver.requireEvent(): T {
    return events.filterIsInstance<T>().first()
}
