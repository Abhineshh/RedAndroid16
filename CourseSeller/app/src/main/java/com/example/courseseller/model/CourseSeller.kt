package com.example.courseseller.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CourseSeller(
    @StringRes val stringResourceId: Int,
    val availabilityNumber: Int,
    @DrawableRes val imageResourceId: Int
)