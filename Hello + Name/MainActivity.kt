package com.example.kotlin_9

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var E: EditText
    lateinit var B: Button
    lateinit var S: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        E = findViewById(R.id.editText)
        B = findViewById(R.id.button)
        S = findViewById(R.id.show)

        B.setOnClickListener {
            S.text =  "Hello ${E.text.toString()}"
        }
    }
}
