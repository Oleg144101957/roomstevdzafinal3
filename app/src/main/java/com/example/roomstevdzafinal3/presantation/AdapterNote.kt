package com.example.roomstevdzafinal3.presantation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.roomstevdzafinal3.databinding.NoteItemBinding
import com.example.roomstevdzafinal3.models.Note

class AdapterNote : RecyclerView.Adapter<AdapterNote.NoteViewHolder>() {
    inner class NoteViewHolder (val binding: NoteItemBinding) : RecyclerView.ViewHolder(binding.root)

    var listOfNotes = emptyList<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(NoteItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = listOfNotes[position]

        holder.binding.apply {
            textViewId.text = note.id.toString()
            textViewTitle.text = note.title
        }

        holder.binding.layoutItem.setOnClickListener {
            val action = StartFragmentDirections.actionStartFragmentToUpdateFragment(note)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount() = listOfNotes.size

    fun setList(list: List<Note>){
        listOfNotes = list
        notifyDataSetChanged()
    }
}