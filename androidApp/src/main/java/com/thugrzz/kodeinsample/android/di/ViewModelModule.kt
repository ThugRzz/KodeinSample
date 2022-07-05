package com.thugrzz.kodeinsample.android.di

import androidx.lifecycle.ViewModelProvider
import com.thugrzz.kodeinsample.android.viewmodels.MainViewModel
import com.thugrzz.kodeinsample.android.viewmodels.ViewModelFactory
import com.thugrzz.kodeinsample.di.DiUtil
import com.thugrzz.kodeinsample.di.notesRepository
import org.kodein.di.*

internal val viewModelModule = DI.Module(
    name = "ViewModelModule",
    init = {
        bind(tag = MainViewModel::class.simpleName!!) {
            provider {
                MainViewModel(instance())
            }
        }
    }
)