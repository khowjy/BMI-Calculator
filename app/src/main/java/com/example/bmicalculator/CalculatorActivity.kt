package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.bmicalculator.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {
    lateinit var binding: ActivityCalculatorBinding
    var bmiValue: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent?.getStringExtra("username")
        val name = findViewById<TextView>(R.id.nameDisplay)
        name.text = username

        val userStatus = findViewById<TextView>(R.id.statusMessage)

        if(savedInstanceState != null){
            bmiValue = savedInstanceState.getDouble("bmiValue")

            if(bmiValue != 0.0){
                val userStatus = findViewById<TextView>(R.id.statusMessage)
                userStatus.setText(bmiStatus())
            }
        }

        binding.calculateButton.setOnClickListener{
            calculateBMI()
            userStatus.setText(bmiStatus())
        }
    }

    override fun onSaveInstanceState(outState:Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("bmiIndex", bmiValue)
    }

    private fun calculateBMI(){
        val weight = findViewById<TextView>(R.id.weightInput).text.toString()
        val height = findViewById<TextView>(R.id.heightInput).text.toString()

        val heightSqr = height.toDouble() * height.toDouble()
        bmiValue = weight.toDouble()/heightSqr
    }

    private fun bmiStatus() :String{
        if(bmiValue < 18.5){
            return "Underweight"
        }
        else if(bmiValue <= 24.9){
            return "Normal weight"
        }
        else if(bmiValue <= 29.9){
            return "Overweight"
        }
        else if(bmiValue <= 34.9){
            return "Obesity Class I"
        }
        else if(bmiValue <= 39.9){
            return "Obesity Class II"
        }
        else {
            return "Obesity Class III"
        }
    }
}
