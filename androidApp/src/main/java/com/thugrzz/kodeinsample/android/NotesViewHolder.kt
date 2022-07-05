package com.thugrzz.kodeinsample.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thugrzz.kodeinsample.data.model.Note

class NotesViewHolder(
    itemView: View,
    private val onDeleteItem: (Note) -> Unit,
) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Note) {
        val noteView = itemView.findViewById<TextView>(R.id.noteView)
        val dateView = itemView.findViewById<TextView>(R.id.dateView)
        val deleteButton = itemView.findViewById<Button>(R.id.deleteButton)
        noteView.text = item.text
        dateView.text = item.createdAt.toString()
        deleteButton.setOnClickListener {
            onDeleteItem(item)
        }
    }

    companion object {

        fun create(viewGroup: ViewGroup, onDeleteItem: (Note) -> Unit): NotesViewHolder {
            val itemView =
                LayoutInflater.from(viewGroup.context).inflate(R.layout.item_note, viewGroup, false)
            return NotesViewHolder(itemView, onDeleteItem)
        }
    }
}