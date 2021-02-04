package com.alex.garminlesson1.utils

import androidx.annotation.ColorRes
import com.alex.garminlesson1.R
import com.alex.garminlesson1.model.BloodPressurePair

enum class BloodPressureEnum(
    val systolicPressure: IntRange,
    val diastolicPressure: IntRange,
    val categoryName: String,
    @ColorRes val categoryColorId: Int
) {
    NORMAL(0..120, 0..80, "Normal", R.color.green),
    ELEVATED(120..130, 0..80, "Elevated", R.color.yellow),
    HIGH_STAGE_ONE(130..140, 80..90, "Hypertension Stage 1", R.color.orange),
    HIGH_STAGE_TWO(140..180, 90..120, "Hypertension Stage 2", R.color.brown),
    HYPERTENSIVE_CRISIS(180..240, 120..240, "Hypertensive Crisis", R.color.red),
    DEAD(240..Integer.MAX_VALUE, 240..Int.MAX_VALUE, "Dead", R.color.black);

    companion object {
        fun verifyBloodPressure(bloodPressurePair: BloodPressurePair): BloodPressureEnum {
            return   if (bloodPressurePair.systolicPressure in HYPERTENSIVE_CRISIS.systolicPressure || bloodPressurePair.diastolicPressure in HYPERTENSIVE_CRISIS.diastolicPressure) {
                HYPERTENSIVE_CRISIS
            }  else if (bloodPressurePair.systolicPressure in HIGH_STAGE_TWO.systolicPressure || bloodPressurePair.diastolicPressure in HIGH_STAGE_TWO.diastolicPressure) {
                HIGH_STAGE_TWO
            } else if (bloodPressurePair.systolicPressure in HIGH_STAGE_ONE.systolicPressure || bloodPressurePair.diastolicPressure in HIGH_STAGE_ONE.diastolicPressure) {
                HIGH_STAGE_ONE
            }  else if (bloodPressurePair.systolicPressure in ELEVATED.systolicPressure && bloodPressurePair.diastolicPressure in ELEVATED.diastolicPressure) {
                ELEVATED
            }  else if (bloodPressurePair.systolicPressure in NORMAL.systolicPressure && bloodPressurePair.diastolicPressure in NORMAL.diastolicPressure) {
                NORMAL
            } else DEAD




//                if (bloodPressurePair.systolicPressure in NORMAL.systolicPressure && bloodPressurePair.diastolicPressure in NORMAL.diastolicPressure) {
//                NORMAL
//            } else if (bloodPressurePair.systolicPressure in ELEVATED.systolicPressure && bloodPressurePair.diastolicPressure in ELEVATED.diastolicPressure) {
//                ELEVATED
//            } else if (bloodPressurePair.systolicPressure in HIGH_STAGE_ONE.systolicPressure || bloodPressurePair.diastolicPressure in HIGH_STAGE_ONE.diastolicPressure) {
//                HIGH_STAGE_ONE
//            } else if (bloodPressurePair.systolicPressure in HIGH_STAGE_TWO.systolicPressure || bloodPressurePair.diastolicPressure in HIGH_STAGE_TWO.diastolicPressure) {
//                HIGH_STAGE_TWO
//            } else if (bloodPressurePair.systolicPressure in HYPERTENSIVE_CRISIS.systolicPressure || bloodPressurePair.diastolicPressure in HYPERTENSIVE_CRISIS.diastolicPressure) {
//                HYPERTENSIVE_CRISIS
//            } else DEAD
        }
    }
}