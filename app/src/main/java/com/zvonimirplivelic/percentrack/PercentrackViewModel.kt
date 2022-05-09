package com.zvonimirplivelic.percentrack

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.zvonimirplivelic.percentrack.db.PercentrackDatabase
import com.zvonimirplivelic.percentrack.model.Exercise
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PercentrackViewModel(application: Application) : AndroidViewModel(application) {

    val getExerciseList: LiveData<List<Exercise>>
    private val repository: PercentrackRepository

    init {
        val percentrackDao = PercentrackDatabase.invoke(application).getPercentrackDao()
        repository = PercentrackRepository(percentrackDao)
        getExerciseList = repository.getExerciseList
    }

    fun addExercise(exercise: Exercise) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addExercise(exercise)
        }
    }

    fun updateExercise(exercise: Exercise) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateExercise(exercise)
        }
    }

    fun deleteExercise(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteExercise(id)
        }
    }
}