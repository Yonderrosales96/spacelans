package com.test.spacelens.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(
        @Expose
        @SerializedName("latitude")
        val latitude: Double,
        @Expose
        @SerializedName("longitude")
        val longitude: Double) : Parcelable