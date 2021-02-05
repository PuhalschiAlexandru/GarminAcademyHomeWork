package com.alex.garminlesson1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.alex.garminlesson1.R
import com.alex.garminlesson1.databinding.ActivityBankExerciseBinding
import com.alex.garminlesson1.databinding.ActivityFactorialExerciseBinding

class BankExerciseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBankExerciseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bank_exercise)
        setUpListener()
    }

    private fun setUpListener() {

    }
}