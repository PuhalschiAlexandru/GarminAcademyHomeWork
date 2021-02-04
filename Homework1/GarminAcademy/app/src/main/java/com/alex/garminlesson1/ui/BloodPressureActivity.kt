package com.alex.garminlesson1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.alex.garminlesson1.R
import com.alex.garminlesson1.databinding.ActivityBloodPressureBinding
import com.alex.garminlesson1.model.BloodPressurePair
import com.alex.garminlesson1.utils.BloodPressureEnum

class BloodPressureActivity : AppCompatActivity() {
    companion object {
        private const val MIN_PRESSURE_RANGE_VALUE = 0
        private const val MAX_PRESSURE_RANGE_VALUE = 240
    }

    private lateinit var binding: ActivityBloodPressureBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setUpListeners()
    }

    private fun setUpListeners() {
        binding.startPressureTestBttn.setOnClickListener {
            val pressure = generateRandomBloodPressurePair()
            val bloodPressureCategory = BloodPressureEnum.verifyBloodPressure(pressure)

            binding.resultsTV.isVisible = true
            binding.resultsTV.setTextColor(ContextCompat.getColor(this, bloodPressureCategory.categoryColorId))

            // It is Better to use string resource
            binding.resultsTV.text =
                "Systolic = ${pressure.systolicPressure} Diastolic = ${pressure.diastolicPressure}, your blood pressure category is: ${bloodPressureCategory.categoryName}"
        }
    }

    private fun generateRandomBloodPressurePair(): BloodPressurePair {
        val randomPressureRange = MIN_PRESSURE_RANGE_VALUE..MAX_PRESSURE_RANGE_VALUE
        return BloodPressurePair(systolicPressure = randomPressureRange.random(), diastolicPressure = randomPressureRange.random())
    }
}