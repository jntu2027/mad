package com.example.usernamepasswordaddressgenderradiobuttonsagedateofbirthstateandasubmitbutton

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val username: EditText = findViewById(R.id.username)
        val password: EditText = findViewById(R.id.password)
        val address: EditText = findViewById(R.id.address)
        val genderradio: RadioGroup = findViewById(R.id.RadioGender)
        val age: EditText = findViewById(R.id.age)
        val DOB: EditText = findViewById(R.id.date)
        val state: EditText = findViewById(R.id.state)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val selectedId = genderradio.checkedRadioButtonId
            val gender = if (selectedId != -1) {
                findViewById<RadioButton>(selectedId).text.toString()
            } else {
                "Not Selected"
            }

            println("UserName : ${username.text}")
            println("Password : ${password.text}")
            println("Address : ${address.text}")
            println("Gender : $gender")
            println("Age : ${age.text}")
            println("DOB : ${DOB.text}")
            println("State : ${state.text}")
        }
    }
}
