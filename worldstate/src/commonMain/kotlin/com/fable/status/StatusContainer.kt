package com.fable.status

interface StatusContainer {

    val statuses: Set<Status<*>>

    fun addStatus(status: Status<*>)

    fun removeStatus(status: Status<*>)
}

inline fun <reified T: Status<*>> StatusContainer.findStatus(): T? {
    return statuses.filterIsInstance<T>()
        .firstOrNull()
}

inline fun <reified T: Status<*>> StatusContainer.requireStatus(): T {
    return statuses.filterIsInstance<T>().first()
}
