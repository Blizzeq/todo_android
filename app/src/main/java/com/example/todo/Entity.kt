package com.example.todo

import androidx.room.Entity
import androidx.room.PrimaryKey

//Plik Entities.kt odpowiada za tworzenie tabel bazy danych i kolumn w nich.

@Entity(tableName = "To_Do")
data class Entity(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var title:String,
    var priority:String
)