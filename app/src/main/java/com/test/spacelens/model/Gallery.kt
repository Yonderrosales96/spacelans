package com.test.spacelens.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Gallery(
        @Expose
        @SerializedName("src")
        val src: String) : Parcelable