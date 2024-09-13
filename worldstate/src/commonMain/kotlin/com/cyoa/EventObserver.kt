package com.cyoa

abstract class EventObserver {
    val events = mutableSetOf<Event<*>>()

    inline fun <reified T: Event<*>> findEvent(): T? {
        return events.filterIsInstance<T>()
            .firstOrNull()
    }

    fun addEvent(event: Event<*>) {
        events.add(event)
    }

    fun removeEvent(event: Event<*>) {
        events.remove(event)
    }
}
