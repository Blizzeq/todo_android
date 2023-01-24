package com.example.todo

//Plik CardInfo.kt odpowiada za przechowywanie informacji o pojedynczym zadaniu, takie jak tytuł i priorytet.

data class CardInfo(
    var title:String,
    var priority:String
)
