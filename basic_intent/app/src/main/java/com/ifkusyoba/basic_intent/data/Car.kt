package com.ifkusyoba.basic_intent.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Car(
    val name: String?,
    val model: String?,
    val weight: Int?,
    val color: String?,
    val transmission: String?
) : Parcelable
