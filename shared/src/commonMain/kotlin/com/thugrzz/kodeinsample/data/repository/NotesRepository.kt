package com.thugrzz.kodeinsample.data.repository

import com.thugrzz.kodeinsample.data.model.Note

interface NotesRepository {

    suspend fun getAllNotes(): List<Note>

    suspend fun removeNote(note: Note)

    suspend fun addNote(note: Note)
}