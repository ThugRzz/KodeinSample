package com.thugrzz.kodeinsample.data.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class Note : RealmObject {
    @PrimaryKey
    var id: Int = 0
    var text: String = ""
    var createdAt: Long = 0

    override fun equals(other: Any?): Boolean {
        return other is Note && id == other.id && text == other.text && createdAt == other.createdAt
    }
}
