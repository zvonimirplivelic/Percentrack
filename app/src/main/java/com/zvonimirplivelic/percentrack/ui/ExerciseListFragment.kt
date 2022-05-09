package com.zvonimirplivelic.percentrack.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.zvonimirplivelic.percentrack.PercentrackViewModel
import com.zvonimirplivelic.percentrack.R
import com.zvonimirplivelic.percentrack.model.Exercise

class ExerciseListFragment : Fragment() {

    private lateinit var viewModel: PercentrackViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var percentrackListAdapter: PercentrackListAdapter

    private lateinit var fabAddExercise: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_exercise_list, container, false)

        percentrackListAdapter = PercentrackListAdapter()
        fabAddExercise = view.findViewById(R.id.fab_add_exercise)
        recyclerView = view.findViewById(R.id.rv_exercise_list)

        recyclerView.apply {
            adapter = percentrackListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel = ViewModelProvider(this)[PercentrackViewModel::class.java]
        viewModel.getExerciseList.observe(viewLifecycleOwner) { exerciseList ->
            percentrackListAdapter.setData(exerciseList)
        }

        fabAddExercise.setOnClickListener {
            findNavController().navigate(R.id.action_exerciseListFragment_to_addExerciseFragment)
        }

        return view
    }

}