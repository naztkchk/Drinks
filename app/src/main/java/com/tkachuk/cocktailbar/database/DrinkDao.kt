package com.tkachuk.cocktailbar.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.tkachuk.cocktailbar.model.Drink

@Dao
interface DrinkDao {

    @get:Query("SELECT * from drinks")
    val allWords: List<Drink>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(drink: Drink)
}