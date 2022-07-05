package com.thugrzz.kodeinsample.android

import com.thugrzz.kodeinsample.data.model.Note

data class MainState(
    val notes: List<Note> = emptyList(),
    val query: String = "",
)
