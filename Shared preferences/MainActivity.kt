package com.example.relative_layout

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val username : EditText = findViewById(R.id.username)
        val pass : EditText = findViewById(R.id.password)
        val save : Button = findViewById(R.id.btnSave)
        val load : Button = findViewById(R.id.btnLoad)

        save.setOnClickListener{
            var sh : SharedPreferences = getSharedPreferences("My" , Context.MODE_PRIVATE)
            var e : SharedPreferences.Editor = sh.edit()

            e.putString("username" , username.text.toString())
            e.putString("password" , pass.text.toString())
            e.commit()
            username.setText("")
            pass.setText("")
            Toast.makeText(this, "Login Saved!", Toast.LENGTH_SHORT).show()
        }

        load.setOnClickListener{
            var sh : SharedPreferences = getSharedPreferences("My" , Context.MODE_PRIVATE)
            username.setText(sh.getString("username" , "None"))
            pass.setText(sh.getString("passowrd" , "None"))
            Toast.makeText(this, "Login Loaded!", Toast.LENGTH_SHORT).show()
        }
    }
}