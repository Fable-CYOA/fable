package com.fable.event

interface Event<T> {
    val outcome: T
}

infix fun <T> Event<T>.matches(value: T) = outcome == value

infix fun <T> Event<T>.doesNotMatch(value: T) = outcome != value
