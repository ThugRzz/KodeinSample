package com.thugrzz.kodeinsample.android

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.thugrzz.kodeinsample.Greeting
import com.thugrzz.kodeinsample.android.di.viewModelModule
import com.thugrzz.kodeinsample.android.viewmodels.MainViewModel
import com.thugrzz.kodeinsample.android.viewmodels.ViewModelFactory
import com.thugrzz.kodeinsample.data.model.Note
import com.thugrzz.kodeinsample.di.dataSourceModule
import com.thugrzz.kodeinsample.di.repositoryModule
import org.kodein.di.*

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity(), DIAware {

    override val di: DI by DI.lazy {
        bind(tag = "test") { singleton { "Test" } }
        bind { singleton { ViewModelFactory(instance()) } }
        import(dataSourceModule)
        import(repositoryModule)
        import(viewModelModule)
    }

    private val viewModel: MainViewModel by di.instance(tag = MainViewModel::class.simpleName!!)

    private val adapter = NotesAdapter(::onDeleteClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<EditText>(R.id.editText).doOnTextChanged { text, _, _, _ ->
            viewModel.onTextChange(text.toString())
        }
        findViewById<Button>(R.id.createButton).setOnClickListener {
            viewModel.onCreateClick()
        }

        findViewById<RecyclerView>(R.id.notesView).adapter = adapter

        lifecycleScope.launchWhenResumed {
            viewModel.state.collect(::onViewStateChanged)
        }
    }

    private fun onDeleteClick(note: Note) {
        viewModel.onDeleteNoteClick(note)
    }

    private fun onViewStateChanged(state: MainState) {
        adapter.submitList(state.notes)
    }
}
