package com.fable.status

interface Status<T : Comparable<T>> {
    val state: T
}
