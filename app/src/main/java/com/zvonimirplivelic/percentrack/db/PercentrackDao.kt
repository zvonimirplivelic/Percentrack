package com.zvonimirplivelic.percentrack.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.zvonimirplivelic.percentrack.model.Exercise

@Dao
interface PercentrackDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addExercise(exercise: Exercise)

    @Update
    suspend fun updateExercise(exercise: Exercise)

    @Query("DELETE FROM exercise WHERE id = :id")
    suspend fun deleteExercise(id: Int)

    @Query("SELECT * FROM exercise")
    fun getExerciseList(): LiveData<List<Exercise>>
}