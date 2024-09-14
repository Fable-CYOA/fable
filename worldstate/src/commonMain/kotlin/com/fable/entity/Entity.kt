package com.fable.entity

import com.fable.event.EventObserver
import com.fable.status.StatusContainer

interface Entity : EventObserver, StatusContainer
