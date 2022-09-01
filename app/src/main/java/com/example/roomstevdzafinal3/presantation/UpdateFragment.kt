package com.example.roomstevdzafinal3.presantation

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.roomstevdzafinal3.R
import com.example.roomstevdzafinal3.databinding.FragmentUpdateBinding
import com.example.roomstevdzafinal3.models.Note


class UpdateFragment : Fragment() {

    private lateinit var binding: FragmentUpdateBinding
    private val args by navArgs<UpdateFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val mViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        binding = FragmentUpdateBinding.inflate(layoutInflater, container, false)

        binding.noteTitle.setText(args.argNote.title)
        binding.description.setText(args.argNote.description)

        binding.save.setOnClickListener {
            val title = binding.noteTitle.text.toString()
            val description = binding.description.text.toString()

            if (checkFields(title, description)){
                val noteToUpdate = Note(args.argNote.id, title, description)
                mViewModel.updateNote(noteToUpdate)
                Toast.makeText(requireContext(), "Updated", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_updateFragment_to_startFragment)

            } else {
                Toast.makeText(requireContext(), "Fill all fields please", Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }

    private fun checkFields(title: String, description: String): Boolean {
        return !(TextUtils.isEmpty(title) || TextUtils.isEmpty(description))
    }

}