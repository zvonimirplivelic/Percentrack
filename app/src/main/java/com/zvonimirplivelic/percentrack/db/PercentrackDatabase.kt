package com.zvonimirplivelic.percentrack.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.zvonimirplivelic.percentrack.model.Exercise
import com.zvonimirplivelic.percentrack.util.Constants.DATABASE_NAME

@Database(
    entities = [Exercise::class],
    version = 1,
    exportSchema = false
)
abstract class PercentrackDatabase : RoomDatabase() {
    abstract fun getPercentrackDao(): PercentrackDao

    companion object {
        @Volatile
        private var INSTANCE: PercentrackDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK) {
            INSTANCE ?: createDatabase(context).also {
                INSTANCE = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                PercentrackDatabase::class.java,
                DATABASE_NAME
            ).fallbackToDestructiveMigration().build()
    }
}