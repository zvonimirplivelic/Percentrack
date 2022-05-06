package com.zvonimirplivelic.percentrack.ui

import android.graphics.Bitmap
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout
import com.zvonimirplivelic.percentrack.PercentrackViewModel
import com.zvonimirplivelic.percentrack.R
import com.zvonimirplivelic.percentrack.model.Exercise
import java.util.*

class AddExerciseFragment : Fragment() {
    private lateinit var viewModel: PercentrackViewModel
    private lateinit var tilExerciseName: TextInputLayout
    private lateinit var tilExercisePr: TextInputLayout
    private lateinit var btnAddVehicle: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_exercise, container, false)

        viewModel = ViewModelProvider(this)[PercentrackViewModel::class.java]

        tilExerciseName = view.findViewById(R.id.til_exercise_name)
        tilExercisePr = view.findViewById(R.id.til_exercise_pr)
        btnAddVehicle = view.findViewById(R.id.btn_add_exercise)

        btnAddVehicle.setOnClickListener {
            addExerciseToDatabase()
        }

        return view
    }

    private fun addExerciseToDatabase() {
        val exerciseName = tilExerciseName.editText?.text.toString()
        val exercisePr = tilExercisePr.editText?.text.toString()

        val exerciseDate = if (tilExercisePr.editText?.text.isNullOrEmpty()) {
            null
        } else {
            Calendar.getInstance().timeInMillis
        }

        if (validateUserInput(exerciseName)) {
            val exercise = Exercise(
                0,
                exerciseName,
                exerciseDate,
                exercisePr.toDouble()
            )

            viewModel.addExercise(exercise)
            Toast.makeText(requireContext(), "Exercise successfully added!", Toast.LENGTH_LONG)
                .show()

            findNavController().navigate(R.id.action_addExerciseFragment_to_exerciseListFragment)
        } else {
            Toast.makeText(
                requireContext(),
                "Please fill out the exercise name!",
                Toast.LENGTH_LONG
            )
                .show()
        }
    }


    private fun validateUserInput(
        exerciseName: String,
    ): Boolean {
        return !(TextUtils.isEmpty(exerciseName))
    }
}