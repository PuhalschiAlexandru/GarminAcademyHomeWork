package com.alex.garminlesson1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.alex.garminlesson1.R
import com.alex.garminlesson1.databinding.ActivityFactorialExerciseBinding
import java.lang.StringBuilder

class FactorialExerciseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFactorialExerciseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_factorial_exercise)
        setUpListener()
    }

    private fun setUpListener() {
        binding.calculateFactorialBttn.setOnClickListener {
            calculateAndDisplayFactorial()
        }
    }

    private fun calculateAndDisplayFactorial() {
        val number = binding.factorialNumberET.text.toString().toInt()
        var factorial = 1L
        val responseText = StringBuilder()
        for (i in 1..number) {
            factorial *= i.toLong()
            responseText.append("* $i")
        }

        binding.resultTv.text = "N = $number -> $number! = $responseText = $factorial"
    }
}