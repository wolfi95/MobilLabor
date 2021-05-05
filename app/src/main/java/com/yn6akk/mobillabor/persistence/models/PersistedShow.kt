package com.yn6akk.mobillabor.persistence.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Favourites")
data class PersistedShow (
    val title: String? = null,
    @PrimaryKey val id: Int? = null,
    val airsOn: String? = null
)