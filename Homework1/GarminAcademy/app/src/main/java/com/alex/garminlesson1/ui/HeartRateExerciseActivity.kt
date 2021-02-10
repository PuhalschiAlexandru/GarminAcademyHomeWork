package com.alex.garminlesson1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.alex.garminlesson1.R
import com.alex.garminlesson1.databinding.ActivityHeartRateExerciseBinding
import com.alex.garminlesson1.model.HeartRateEntry

class HeartRateExerciseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHeartRateExerciseBinding
    private val data = populateData(
        1612310400L to 76,
        1612310400L to 89,
        1612310400L to 44,
        1612224000L to 47,
        1612224000L to 115,
        1612224000L to 76,
        1612224000L to 87,
        1612137600L to 90,
        1612137600L to 167
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_heart_rate_exercise)
        setUpListener()
    }

    private fun setUpListener() {
        binding.showResultsBttn.setOnClickListener {
            showResults()
        }
    }

    private fun populateData(vararg dataPair: Pair<Long, Int>): List<HeartRateEntry> =
        dataPair.map { HeartRateEntry(it.first, it.second) }

    private fun showResults() {
        val map = mutableMapOf<Long, List<Int>>()
        val maxValueMap = mutableMapOf<Long, Int>()
        val dateList = data.distinctBy { it.date }
        dateList.forEach { map[it.date] = getAllHeartRatesValueForTheDate(it.date) }
        map.forEach { entrty -> maxValueMap[entrty.key] = entrty.value.maxOf { it } }
        binding.resultsTV.text =
            "Min value = ${data.minOf { it.value }} \n Heart rates above 100 = ${data.filter { it.value > 100 }} \n Heart rate map = $map  \n Maximum hear rate values = $maxValueMap "
    }

    private fun getAllHeartRatesValueForTheDate(date: Long): List<Int> {
        val listOfHeartRates = ArrayList<Int>()
        val filteredList = data.filter { it.date == date }
        filteredList.forEach { listOfHeartRates.add(it.value) }
        return listOfHeartRates
    }
}


