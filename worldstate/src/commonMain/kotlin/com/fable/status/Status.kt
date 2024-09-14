package com.fable.status

interface Status<T : Comparable<T>> {
    var state: T
}
