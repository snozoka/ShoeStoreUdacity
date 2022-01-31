package com.example.shoestoreudacity.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoes (var name: String, var size: Double, var company: String, var description: String,
                  val images: List<String> = mutableListOf()) : Parcelable