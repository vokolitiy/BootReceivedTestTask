package com.example.auratesttask.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import org.bson.types.ObjectId

open class BootEventReceived : RealmObject() {

    @PrimaryKey
    @JvmField
    var id: ObjectId = ObjectId()

    @JvmField
    var previousReceived: Long = 0

    @JvmField
    var lastTimeReceived: Long = 0
}