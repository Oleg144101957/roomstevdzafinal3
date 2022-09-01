package com.example.roomstevdzafinal3.presantation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomstevdzafinal3.R
import com.example.roomstevdzafinal3.databinding.FragmentStartBinding
import com.example.roomstevdzafinal3.models.Note

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding
    private lateinit var adapter: AdapterNote
    private lateinit var recycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val mViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        adapter = AdapterNote()
        recycler = binding.recyclerView
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireContext())

        mViewModel.mLiveData.observe(viewLifecycleOwner, { list ->
            adapter.setList(list)
        })

        binding.addNote.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_addFragment)
        }

        val swipeGesture = object : SwipeGesture(){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val noteToDelete = adapter.listOfNotes[viewHolder.adapterPosition]
                mViewModel.deleteNote(noteToDelete)
                adapter.notifyDataSetChanged()
                Toast.makeText(requireContext(), "Deleted", Toast.LENGTH_SHORT).show()
            }
        }

        val touchHelper = ItemTouchHelper(swipeGesture)
        touchHelper.attachToRecyclerView(recycler)

        return binding.root
    }

}