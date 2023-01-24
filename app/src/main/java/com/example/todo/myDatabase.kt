package com.example.todo

import androidx.room.Database
import androidx.room.RoomDatabase

//Plik myDatabase.kt odpowiada za tworzenie instancji bazy danych i dostęp do niej.

@Database(entities = [Entity::class],version=1)
abstract class myDatabase : RoomDatabase() {
    abstract fun dao():DAO
}