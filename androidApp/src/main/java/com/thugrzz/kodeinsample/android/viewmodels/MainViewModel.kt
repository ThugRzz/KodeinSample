package com.thugrzz.kodeinsample.android.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thugrzz.kodeinsample.android.MainState
import com.thugrzz.kodeinsample.data.model.Note
import com.thugrzz.kodeinsample.data.repository.NotesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val notesRepository: NotesRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    init {
        fetchAllNotes()
    }

    fun onTextChange(text: String) {
        val prevState = _state.value
        _state.value = prevState.copy(query = text)
    }

    fun onCreateClick() {
        viewModelScope.launch {
            val text = state.value.query
            val note = Note().apply {
                id = System.currentTimeMillis().toInt()
                this.text = text
                createdAt = System.currentTimeMillis()
            }
            notesRepository.addNote(note)
            fetchAllNotes()
        }
    }

    fun onDeleteNoteClick(note: Note) {
        viewModelScope.launch {
            notesRepository.removeNote(note)
            fetchAllNotes()
        }
    }

    private fun fetchAllNotes() {
        viewModelScope.launch {
            val prevState = _state.value
            _state.value = prevState.copy(notes = notesRepository.getAllNotes())
        }
    }
}