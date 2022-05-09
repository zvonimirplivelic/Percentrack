package com.zvonimirplivelic.percentrack.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.zvonimirplivelic.percentrack.R
import com.zvonimirplivelic.percentrack.model.Exercise
import com.zvonimirplivelic.percentrack.util.DiffUtilExtension.autoNotify
import kotlin.properties.Delegates

class PercentrackListAdapter() : RecyclerView.Adapter<PercentrackListAdapter.ExerciseViewHolder>() {

    private var exerciseList: List<Exercise> by Delegates.observable(emptyList()) { _, oldList, newList ->
        autoNotify(oldList, newList) { o, n -> o.id == n.id }
    }

    class ExerciseViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        return ExerciseViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.exercise_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        holder.itemView.apply {
            val exercise = exerciseList[position]

            val tvExerciseName: TextView = findViewById(R.id.tv_exercise_name_list)
            val tvExercisePr: TextView = findViewById(R.id.tv_exercise_pr_list)
            val tvExercisePrDate: TextView = findViewById(R.id.tv_exercise_pr_date_list)

            tvExerciseName.text = exercise.name
            tvExercisePr.text = exercise.prWeight.toString()
            tvExercisePrDate.text = exercise.prDate.toString()

            setOnClickListener {
                val action =
                    ExerciseListFragmentDirections
                        .actionExerciseListFragmentToExerciseInfoFragment(
                            exercise
                        )
                findNavController().navigate(action)
            }

        }
    }

    override fun getItemCount(): Int = exerciseList.size


    fun setData(exerciseList: List<Exercise>) {
        this.exerciseList = exerciseList
    }
}