package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameVerification = findViewById<View>(R.id.enterButton)
        nameVerification.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            val username = findViewById<TextView>(R.id.nameInput).text
            intent.putExtra("username", username.toString())
            startActivity(intent)
        }
    }
}