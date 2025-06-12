package com.example.kotlin_9
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

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
        val DOB: DatePicker = findViewById(R.id.date)
        val state: Spinner = findViewById(R.id.state)
        val button: Button = findViewById(R.id.button)

        val states = listOf("Select State" , "Telangana" , "Andhra Pradesh" , "UP" , "Bihar")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, states)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        state.adapter = adapter

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
            println("DOB : ${DOB.dayOfMonth}/${DOB.month + 1}/${DOB.year}")
            println("State : ${state.selectedItem.toString()}")
        }
    }
}
