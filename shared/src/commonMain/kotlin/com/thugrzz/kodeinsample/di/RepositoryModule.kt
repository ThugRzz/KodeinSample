package com.thugrzz.kodeinsample.di

import com.thugrzz.kodeinsample.data.repository.NotesRepositoryImpl
import com.thugrzz.kodeinsample.data.repository.NotesRepository
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val repositoryModule = DI.Module(
    name = "RepositoryModule",
    init = {
        bind<NotesRepository> { singleton { NotesRepositoryImpl(instance()) } }
    }
)

val DiUtil.notesRepository: NotesRepository
    get() = DiUtil.di.instance()