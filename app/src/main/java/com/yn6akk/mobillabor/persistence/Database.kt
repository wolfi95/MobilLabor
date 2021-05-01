package com.yn6akk.mobillabor.persistence

import android.content.Context
import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yn6akk.mobillabor.persistence.models.PersistedShow

@Database(entities = arrayOf(PersistedShow::class), version = 1, exportSchema = false)
public abstract class Database : RoomDatabase() {

    abstract fun favouritesdDao(): FavouritesDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: com.yn6akk.mobillabor.persistence.Database? = null

        fun getDatabase(context: Context): com.yn6akk.mobillabor.persistence.Database {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    com.yn6akk.mobillabor.persistence.Database::class.java,
                    "favourites_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}