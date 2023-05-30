package com.example.auratesttask

import com.example.auratesttask.model.BootEventReceived
import io.realm.Realm

class BootCompletedRepository {

    fun findReceivedBoots(): List<BootEventReceived> = Realm.getDefaultInstance().use {
        it.where(BootEventReceived::class.java).findAll()
    }

    fun hasSingleBootRecord(): Boolean = if (findReceivedBoots().isEmpty()) {
        false
    } else {
        findReceivedBoots().size > 1
    }

    fun findBootTimeDiff(): Long = if (findReceivedBoots().isEmpty()) {
        0
    } else {
        val last = findReceivedBoots().last()
        last.lastTimeReceived - last.previousReceived
    }
}