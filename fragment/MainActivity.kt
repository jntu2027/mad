package com.example.frag


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnFragment1 = findViewById<Button>(R.id.buttonFragment1)
        val btnFragment2 = findViewById<Button>(R.id.buttonFragment2)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, Fragment1())
            .commit()

        btnFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Fragment1())
                .commit()
        }

        btnFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Fragment2())
                .commit()
        }
    }
}
