package com.example.relative_layout

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MainActivity : AppCompatActivity() {

    private lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editName = findViewById<EditText>(R.id.editName)
        val editAge = findViewById<EditText>(R.id.editAge)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnShow = findViewById<Button>(R.id.btnShow)
        val textResult = findViewById<TextView>(R.id.textResult)

        db = DatabaseHelper(this)

        btnSave.setOnClickListener {
            val name = editName.text.toString()
            val age = editAge.text.toString().toIntOrNull()
            if (name.isNotEmpty() && age != null) {
                val isInserted = db.insertData(name, age)
                Toast.makeText(this, if (isInserted) "Data Saved" else "Error", Toast.LENGTH_SHORT).show()
                editName.text.clear()
                editAge.text.clear()
            } else {
                Toast.makeText(this, "Enter valid name and age", Toast.LENGTH_SHORT).show()
            }
        }

        btnShow.setOnClickListener {
            textResult.text = db.getAllData()
        }
    }
}

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "MyDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age INTEGER)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun insertData(name: String, age: Int): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put("name", name)
            put("age", age)
        }
        val result = db.insert("users", null, contentValues)
        return result != -1L
    }

    fun getAllData(): String {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM users", null)
        val buffer = StringBuilder()
        while (cursor.moveToNext()) {
            val name = cursor.getString(1)
            val age = cursor.getInt(2)
            buffer.append("Name: $name, Age: $age\n")
        }
        cursor.close()
        return buffer.toString()
    }
}

