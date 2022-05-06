package com.zvonimirplivelic.percentrack.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.google.android.material.textfield.TextInputLayout
import com.zvonimirplivelic.percentrack.PercentrackViewModel
import com.zvonimirplivelic.percentrack.R

class ExerciseInfoFragment : Fragment() {

    private val args by navArgs<ExerciseInfoFragmentArgs>()
    private lateinit var viewModel: PercentrackViewModel

    private lateinit var tvUpdateExerciseName: TextView
    private lateinit var ibUpdateExerciseName: ImageButton
    private lateinit var tilUpdateExercisePr: TextInputLayout
    private lateinit var tvUpdatedPrDate: TextView
    private lateinit var btnUpdateExercise: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_exercise_info, container, false)

        viewModel = ViewModelProvider(this)[PercentrackViewModel::class.java]

        tvUpdateExerciseName = view.findViewById(R.id.tv_update_exercise_name)
        ibUpdateExerciseName = view.findViewById(R.id.ib_update_exercise_name)
        tilUpdateExercisePr = view.findViewById(R.id.til_update_exercise_pr)
        tvUpdatedPrDate = view.findViewById(R.id.tv_exercise_pr_updated_date)
        btnUpdateExercise = view.findViewById(R.id.btn_update_exercise)

        tvUpdateExerciseName.text = args.exercise.name
        tilUpdateExercisePr.editText?.setText(args.exercise.prWeight.toString())
        tvUpdatedPrDate.text = args.exercise.prDate.toString()

        ibUpdateExerciseName.setOnClickListener {
            
        }

        btnUpdateExercise.setOnClickListener {

        }

        return view
    }
}