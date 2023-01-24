package com.example.todo

import androidx.room.*

//Plik DAO.kt (Data Access Object) odpowiada za dostęp do bazy danych,
// w tym za wykonywanie operacji CRUD (Create, Read, Update, Delete) na zadaniach.

@Dao
interface DAO {
    @Insert
    suspend fun insertTask(entity: Entity)

    @Update
    suspend fun updateTask(entity: Entity)

    @Delete
    suspend fun deleteTask(entity: Entity)

    @Query("Delete from to_do")
    suspend fun deleteAll()

    @Query("Select * from to_do")
    suspend fun getTasks():List<CardInfo>

}