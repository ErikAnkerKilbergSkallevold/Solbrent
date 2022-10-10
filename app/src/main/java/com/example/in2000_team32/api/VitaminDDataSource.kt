package com.example.in2000_team32.api

import java.util.*

//Finds location based on lat-long and finds lat-long from location
class VitaminDDataSource {
    fun calculateVitaminDUIPerHour(fitztype: Number, hemisphere : String, uvindex: Number) : Double {
        var vitaminDUIPerHour = 0.0
        val currentSeason: String
        val hemisphere = hemisphere
        val currentMonth = Calendar.getInstance().get(Calendar.MONTH)

        //Calculate vitamin d production in ug/hour
        //1. Find current season based on current month
        currentSeason = if (currentMonth in 0..2) {
            if (hemisphere == "north") "winter" else "summer"
        } else if (currentMonth in 3..5) {
            if (hemisphere == "north") "spring" else "autumn"
        } else if (currentMonth in 6..8) {
            if (hemisphere == "north") "summer" else "winter"
        } else if (currentMonth in 9..11) {
            if (hemisphere == "north") "autumn" else "spring"
        } else {
            if (hemisphere == "north") "winter" else "summer"
        }

        //Calculate vitamin d production based on season
        when (currentSeason) {
            "winter" -> {
                //Winter implies only arms and face
                when (uvindex) {
                    1 -> vitaminDUIPerHour = 400.0
                    2 -> vitaminDUIPerHour = 750.0
                    3 -> vitaminDUIPerHour = 1200.0
                    4 -> vitaminDUIPerHour = 1580.0
                    5 -> vitaminDUIPerHour = 2400.0
                    6 -> vitaminDUIPerHour = 3000.0
                    7 -> vitaminDUIPerHour = 3530.0
                    8 -> vitaminDUIPerHour = 4000.0
                    9 -> vitaminDUIPerHour = 4615.0
                    10 -> vitaminDUIPerHour = 6000.0
                    11 -> vitaminDUIPerHour = 6666.0
                    12 -> vitaminDUIPerHour = 7500.0
                    13 -> vitaminDUIPerHour = 8570.0
                    14 -> vitaminDUIPerHour = 10000.0
                    15 -> vitaminDUIPerHour = 12000.0
                }
            }
            "summer" -> {
                //Summer implies nakedness
                when (uvindex) {
                    1 -> vitaminDUIPerHour = 3000.0
                    2 -> vitaminDUIPerHour = 7500.0
                    3 -> vitaminDUIPerHour = 12000.0
                    4 -> vitaminDUIPerHour = 20000.0
                    5 -> vitaminDUIPerHour = 24000.0
                    6 -> vitaminDUIPerHour = 30000.0
                    7 -> vitaminDUIPerHour = 31500.0
                    8 -> vitaminDUIPerHour = 33333.0
                    9 -> vitaminDUIPerHour = 40000.0
                    10 -> vitaminDUIPerHour = 46000.0
                    11 -> vitaminDUIPerHour = 54500.0
                    12 -> vitaminDUIPerHour = 60000.0
                    13 -> vitaminDUIPerHour = 66666.0
                    14 -> vitaminDUIPerHour = 75000.0
                    15 -> vitaminDUIPerHour = 85000.0
                }
            }
            //Autumn og Spring
            else -> {
                //Spring or summer  implies nakedness
                when (uvindex.toInt()) {
                    1 -> vitaminDUIPerHour = 750.0
                    2 -> vitaminDUIPerHour = 1500.0
                    3 -> vitaminDUIPerHour = 3333.0
                    4 -> vitaminDUIPerHour = 4285.0
                    5 -> vitaminDUIPerHour = 6666.0
                    6 -> vitaminDUIPerHour = 7500.0
                    7 -> vitaminDUIPerHour = 10000.0
                    8 -> vitaminDUIPerHour = 11000.0
                    9 -> vitaminDUIPerHour = 12000.0
                    10 -> vitaminDUIPerHour = 13333.0
                    11 -> vitaminDUIPerHour = 15000.0
                    12 -> vitaminDUIPerHour = 15000.0
                    13 -> vitaminDUIPerHour = 15800.0
                    14 -> vitaminDUIPerHour = 15800.0
                    15 -> vitaminDUIPerHour = 17150.0
                }
            }
        }
        //Change VitaminDUIPerHour based on skin type

        when (fitztype.toInt()) {
            in 1..2 -> {
                vitaminDUIPerHour /= 1
            }
            in 3..4 -> {
                vitaminDUIPerHour /= 2
            }
            in 5..6 -> {
                vitaminDUIPerHour /= 5
            }
        }

        return vitaminDUIPerHour
    }

    fun calculateTimeTillSunBurn(fitztype: Number, uvindex: Number ) : Number {
        //Calculate time till sunburn
        var timeTillSunburn = 0.0

        when (uvindex.toInt()) {
            1 -> timeTillSunburn = 150.0
            2 -> timeTillSunburn = 100.0
            3 -> timeTillSunburn = 70.0
            4 -> timeTillSunburn = 50.0
            5 -> timeTillSunburn = 40.0
            6 -> timeTillSunburn = 38.0
            7 -> timeTillSunburn = 35.0
            8 -> timeTillSunburn = 30.0
            9 -> timeTillSunburn = 25.0
            10 -> timeTillSunburn = 20.0
            11 -> timeTillSunburn = 19.0
            12 -> timeTillSunburn = 18.0
            13 -> timeTillSunburn = 17.0
            14 -> timeTillSunburn = 16.0
            15 -> timeTillSunburn = 15.0
        }

        //Check skin type and adjust timeTillSunburn
        when (fitztype.toInt()) {
            in 1..2 -> {
                timeTillSunburn *= 1
            }
            in 3..4 -> {
                timeTillSunburn *= 2
            }
            in 5..6 -> {
                timeTillSunburn *= 5
            }
        }

        return timeTillSunburn

    }

}