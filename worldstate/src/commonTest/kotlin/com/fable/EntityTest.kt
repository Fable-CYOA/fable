package com.fable

import com.fable.entity.Entity
import com.fable.event.Event
import kotlin.test.Test
import kotlin.test.assertTrue

class EntityTest {

    @Test fun `test entity`() {
        val entity = ConcreteEntity()
        (1..100).forEach { t -> entity.addEvent(IntegerEvent(t)) }
        entity.addEvent(BooleanEvent(true))

        assertTrue(entity.findEvent<BooleanEvent>()!!.outcome)
    }
}

class ConcreteEntity : Entity()

class IntegerEvent(override val outcome: Int) : Event<Int>

class BooleanEvent(override val outcome: Boolean) : Event<Boolean>
