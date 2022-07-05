package com.thugrzz.kodeinsample.data.repository

import com.thugrzz.kodeinsample.data.model.Note
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.find

class NotesRepositoryImpl(
    private val realm: Realm,
) : NotesRepository {

    override suspend fun addNote(note: Note) {
        realm.writeBlocking {
            copyToRealm(note)
        }
    }

    override suspend fun getAllNotes(): List<Note> = realm.query<Note>().find()

    override suspend fun removeNote(note: Note) {
        realm.writeBlocking {
            val deleteUser = query<Note>().find { it.query("id ==$0", note.id) }
            delete(deleteUser)
        }
    }
}