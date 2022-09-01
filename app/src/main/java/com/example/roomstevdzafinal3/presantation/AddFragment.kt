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
import com.example.roomstevdzafinal3.R
import com.example.roomstevdzafinal3.databinding.FragmentAddBinding
import com.example.roomstevdzafinal3.models.Note


class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val mViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        binding = FragmentAddBinding.inflate(layoutInflater, container, false)
        binding.save.setOnClickListener {

            val title = binding.noteTitle.text.toString()
            val descriprion = binding.description.text.toString()

            if (checkFields(title, descriprion)){
                val noteToAdd = Note(title = title, description = descriprion)
                mViewModel.addNote(noteToAdd)
                Toast.makeText(requireContext(), "Added", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_addFragment_to_startFragment)

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