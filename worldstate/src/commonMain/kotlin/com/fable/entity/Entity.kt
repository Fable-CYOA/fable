package com.fable.entity

import com.fable.event.DefaultEventObserver
import com.fable.event.EventObserver

abstract class Entity : EventObserver by DefaultEventObserver()
