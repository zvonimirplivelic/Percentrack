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
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.textfield.TextInputLayout
import com.zvonimirplivelic.percentrack.PercentrackViewModel
import com.zvonimirplivelic.percentrack.R
import com.zvonimirplivelic.percentrack.model.Exercise
import com.zvonimirplivelic.percentrack.util.Constants.EIGHTY_FIVE_PERCENT
import com.zvonimirplivelic.percentrack.util.Constants.EIGHTY_PERCENT
import com.zvonimirplivelic.percentrack.util.Constants.EIGHTY_SEVEN_PERCENT
import com.zvonimirplivelic.percentrack.util.Constants.EIGHTY_THREE_PERCENT
import com.zvonimirplivelic.percentrack.util.Constants.HUNDRED_PERCENT
import com.zvonimirplivelic.percentrack.util.Constants.NINETY_FIVE_PERCENT
import com.zvonimirplivelic.percentrack.util.Constants.NINETY_PERCENT
import com.zvonimirplivelic.percentrack.util.Constants.NINETY_THREE_PERCENT
import com.zvonimirplivelic.percentrack.util.Constants.SEVENTY_FIVE_PERCENT
import com.zvonimirplivelic.percentrack.util.Constants.SEVENTY_PERCENT
import com.zvonimirplivelic.percentrack.util.Constants.SEVENTY_SEVEN_PERCENT
import com.zvonimirplivelic.percentrack.util.Constants.SIXTY_SEVEN_PERCENT
import java.util.*
import kotlin.math.roundToInt

class ExerciseInfoFragment : Fragment() {

    private val args by navArgs<ExerciseInfoFragmentArgs>()
    private lateinit var viewModel: PercentrackViewModel

    private lateinit var tvUpdateExerciseName: TextView
    private lateinit var ibUpdateExerciseName: ImageButton
    private lateinit var tilUpdateExercisePr: TextInputLayout
    private lateinit var tvUpdatedPrDate: TextView
    private lateinit var btnUpdateExercise: Button

    private lateinit var tvHundredPct: TextView
    private lateinit var tvNinetyFivePct: TextView
    private lateinit var tvNinetyThreePct: TextView
    private lateinit var tvNinetyPct: TextView
    private lateinit var tvEightySevenPct: TextView
    private lateinit var tvEightyFivePct: TextView
    private lateinit var tvEightyThreePct: TextView
    private lateinit var tvEightyPct: TextView
    private lateinit var tvSeventySevenPct: TextView
    private lateinit var tvSeventyFivePct: TextView
    private lateinit var tvSeventyPct: TextView
    private lateinit var tvSixtySevenPct: TextView

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

        tvHundredPct = view.findViewById(R.id.tv_100_percent)
        tvNinetyFivePct = view.findViewById(R.id.tv_95_percent)
        tvNinetyThreePct = view.findViewById(R.id.tv_93_percent)
        tvNinetyPct = view.findViewById(R.id.tv_90_percent)
        tvEightySevenPct = view.findViewById(R.id.tv_87_percent)
        tvEightyFivePct = view.findViewById(R.id.tv_85_percent)
        tvEightyThreePct = view.findViewById(R.id.tv_83_percent)
        tvEightyPct = view.findViewById(R.id.tv_80_percent)
        tvSeventySevenPct = view.findViewById(R.id.tv_77_percent)
        tvSeventyFivePct = view.findViewById(R.id.tv_75_percent)
        tvSeventyPct = view.findViewById(R.id.tv_70_percent)
        tvSixtySevenPct = view.findViewById(R.id.tv_67_percent)

        tvHundredPct.text = resources.getString(
            R.string.weight_in_percentage_string,
            convertPrWeightToString(HUNDRED_PERCENT)
        )

        tvNinetyFivePct.text = resources.getString(
            R.string.weight_in_percentage_string,
            convertPrWeightToString(NINETY_FIVE_PERCENT)
        )

        tvNinetyThreePct.text = resources.getString(
            R.string.weight_in_percentage_string,
            convertPrWeightToString(NINETY_THREE_PERCENT)
        )

        tvNinetyPct.text = resources.getString(
            R.string.weight_in_percentage_string,
            convertPrWeightToString(NINETY_PERCENT)
        )

        tvEightySevenPct.text = resources.getString(
            R.string.weight_in_percentage_string,
            convertPrWeightToString(EIGHTY_SEVEN_PERCENT)
        )

        tvEightyFivePct.text = resources.getString(
            R.string.weight_in_percentage_string,
            convertPrWeightToString(EIGHTY_FIVE_PERCENT)
        )

        tvEightyThreePct.text = resources.getString(
            R.string.weight_in_percentage_string,
            convertPrWeightToString(EIGHTY_THREE_PERCENT)
        )

        tvEightyPct.text = resources.getString(
            R.string.weight_in_percentage_string,
            convertPrWeightToString(EIGHTY_PERCENT)
        )

        tvSeventySevenPct.text = resources.getString(
            R.string.weight_in_percentage_string,
            convertPrWeightToString(SEVENTY_SEVEN_PERCENT)
        )

        tvSeventyFivePct.text = resources.getString(
            R.string.weight_in_percentage_string,
            convertPrWeightToString(SEVENTY_FIVE_PERCENT)
        )

        tvSeventyPct.text = resources.getString(
            R.string.weight_in_percentage_string,
            convertPrWeightToString(SEVENTY_PERCENT)
        )

        tvSixtySevenPct.text = resources.getString(
            R.string.weight_in_percentage_string,
            convertPrWeightToString(SIXTY_SEVEN_PERCENT)
        )

        tvUpdateExerciseName.text = args.exercise.name
        tilUpdateExercisePr.editText?.setText(args.exercise.prWeight.toString())
        tvUpdatedPrDate.text = args.exercise.prDate.toString()

        ibUpdateExerciseName.setOnClickListener {

        }

        btnUpdateExercise.setOnClickListener {
            viewModel.updateExercise(
                Exercise(
                    args.exercise.id,
                    tvUpdateExerciseName.text.toString(),
                    Calendar.getInstance().timeInMillis,
                    tilUpdateExercisePr.editText?.text.toString().toDouble()
                )
            )
            findNavController().navigate(R.id.action_exerciseInfoFragment_to_exerciseListFragment)
        }

        return view
    }

    private fun convertPrWeightToString(percent: Double): String {
        val prWeight = args.exercise.prWeight
        val prWeightToPercent = prWeight?.times(percent)

        prWeightToPercent?.roundToInt()
        return prWeightToPercent.toString()
    }
}