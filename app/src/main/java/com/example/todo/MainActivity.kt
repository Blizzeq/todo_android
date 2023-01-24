package com.example.todo


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

//Plik MainActivity.kt odpowiada za główną aktywność aplikacji,
// w tym za wyświetlanie listy zadań oraz dodawanie i usuwanie zadań.

class MainActivity : AppCompatActivity() {
    private lateinit var database: myDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        task_counter.text = DataObject.getAllData().size.toString() + " tasks"
        database = Room.databaseBuilder(
            applicationContext, myDatabase::class.java, "To_Do"
        ).build()
        add.setOnClickListener {
            val intent = Intent(this, CreateCard::class.java)
            startActivity(intent)
        }
        deleteAll.setOnClickListener {
            DataObject.deleteAll()
            task_counter.text = DataObject.getAllData().size.toString() + " tasks"
            GlobalScope.launch {
                database.dao().deleteAll()
            }
            setRecycler()
            val toast = Toast.makeText(this, "All tasks successfully deleted!", Toast.LENGTH_SHORT)
            toast.show()
        }

        setRecycler()

    }

    fun setRecycler() {
        recycler_view.adapter = Adapter(DataObject.getAllData())
        recycler_view.layoutManager = LinearLayoutManager(this)
        task_counter.text = DataObject.getAllData().size.toString() + " tasks"
    }
}