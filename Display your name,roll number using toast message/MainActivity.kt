package com.example.displayyournamerollnumberusingtoastmessage

import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val rollEditText = findViewById<EditText>(R.id.rollEditText)
        val showButton = findViewById<Button>(R.id.showButton)

        showButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val roll = rollEditText.text.toString().trim()
            val message = "Name: $name\nRoll No: $roll"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }
}
