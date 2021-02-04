package com.alex.garminlesson1.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alex.garminlesson1.R
import com.alex.garminlesson1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setUpListeners()
    }

    private fun setUpListeners() {
        binding.bloodPressureExerciseBttn.setOnClickListener {
            startActivity(BankExerciseActivity::class.java)
        }
        binding.bankExerciseBttn.setOnClickListener {
            startActivity(BankExerciseActivity::class.java)
        }
        binding.factorialExerciseBttn.setOnClickListener {
            startActivity(FactorialExerciseActivity::class.java)
        }
    }

    private fun startActivity(clazz: Class<*>) {
        startActivity(Intent(this, clazz))
    }
}