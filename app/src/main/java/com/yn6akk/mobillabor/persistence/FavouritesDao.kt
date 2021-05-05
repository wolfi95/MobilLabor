package com.yn6akk.mobillabor.persistence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.yn6akk.mobillabor.persistence.models.PersistedShow

@Dao
interface FavouritesDao {
    @Query("SELECT * FROM Favourites")
    fun getAllFavourites(): List<PersistedShow>

    @Insert
    fun addFavourite(vararg fav: PersistedShow)

    @Delete
    fun deleteFavourite(fav: PersistedShow)

    @Query("SELECT * FROM Favourites as fv WHERE fv.id=:id")
    fun getavouriteById(id: Int): PersistedShow?
}