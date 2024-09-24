package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ShowDao {

    /* Get all shows */
    @Query("SELECT * FROM shows")
    fun getAllShows(): Flow<List<Show>>

    /* Get a show */
    @Query("SELECT * FROM shows WHERE showID = :showID")
    fun getShow(showID: Int): Flow<Show?>

    /* Insert a new show */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(show: Show)

    /* Update a show's details */
    @Update
    suspend fun update(show: Show)

    /* Delete a show */
    @Delete
    suspend fun delete(show: Show)

}