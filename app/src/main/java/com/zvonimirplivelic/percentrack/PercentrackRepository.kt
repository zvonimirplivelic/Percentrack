package com.zvonimirplivelic.percentrack

import androidx.lifecycle.LiveData
import com.zvonimirplivelic.percentrack.db.PercentrackDao
import com.zvonimirplivelic.percentrack.model.Exercise

class PercentrackRepository(private val percentrackDao: PercentrackDao) {

    val getExerciseList: LiveData<List<Exercise>> = percentrackDao.getExerciseList()

    suspend fun addExercise(exercise: Exercise) {
        percentrackDao.addExercise(exercise)
    }

    suspend fun updateExercise(exercise: Exercise) {
        percentrackDao.updateExercise(exercise)
    }

    suspend fun deleteExercise(id: Int) {
        percentrackDao.deleteExercise(id)
    }
}