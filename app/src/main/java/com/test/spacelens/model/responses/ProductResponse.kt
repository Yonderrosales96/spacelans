package com.test.spacelens.model.responses

import android.os.Parcelable
import com.test.spacelens.model.Products
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductResponse(val code : String, val message_error : String, val products : List<Products> ) : Parcelable