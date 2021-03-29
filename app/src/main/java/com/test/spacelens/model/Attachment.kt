package com.test.spacelens.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Attachment(
        @Expose
        @SerializedName("url")
        val url: String,
        @Expose
        @SerializedName("type")
        val type: String,
        @Expose
        @SerializedName("thumbnail")
        val thumbnail: String) : Parcelable