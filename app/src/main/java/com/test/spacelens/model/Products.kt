package com.test.spacelens.model

import android.R
import android.os.Parcelable
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Products(
        @Expose
        @SerializedName("product_id")
        var productId: Int,
        @Expose
        @SerializedName("owner")
        val owner: String,
        @Expose
        @SerializedName("created")
        val created: String,
        @Expose
        @SerializedName("likes")
        var likes: Int,
        @Expose
        @SerializedName("address")
        val address: String,
        @Expose
        @SerializedName("createdTime")
        val createdtime: String,
        @Expose
        @SerializedName("is_private")
        val isPrivate: String,
        @Expose
        @SerializedName("price")
        var price: Int,
        @Expose
        @SerializedName("p_condition")
        val pCondition: String,
        @Expose
        @SerializedName("category")
        val category: String,
        @Expose
        @SerializedName("payment_method")
        val paymentMethod: String,
        @Expose
        @SerializedName("title")
        val title: String,
        @Expose
        @SerializedName("description")
        val description: String,
        @Expose
        @SerializedName("currency")
        val currency: String,
        @Expose
        @SerializedName("offer")
        var offer: Boolean,
        @Expose
        @SerializedName("rating_product")
        var ratingProduct: Int,
        @Expose
        @SerializedName("rating_amount")
        var ratingAmount: Int,
        @Expose
        @SerializedName("distance")
        var distance: Int,
        @Expose
        @SerializedName("attachment")
        var attachment: Attachment,
        @Expose
        @SerializedName("gallery")
        var gallery: List<Gallery>,
        @Expose
        @SerializedName("like_user")
        var likeUser: Boolean,
        @Expose
        @SerializedName("location")
        var location: Location) : Parcelable{


        companion object {
                @JvmStatic
                @BindingAdapter("avatar")
                fun loadImage(imageView: ImageView, url: String?) {
                        if (url!=null) {
                                Glide.with(imageView.context)
                                        .setDefaultRequestOptions(
                                                RequestOptions()
                                                        .circleCrop()
                                        )
                                        .load(url)
                                        .into(imageView)
                        }
                }

                @JvmStatic
                @BindingAdapter("imageDetail")
                fun loadImageDetail(imageView: ImageView, url: String?) {
                        if (url!=null) {
                                Glide.with(imageView.context)
                                        .setDefaultRequestOptions(
                                                RequestOptions()
                                        )
                                        .load(url)
                                        .into(imageView)
                        }
                }

                @JvmStatic
                @BindingAdapter("toInt")
                fun putLikes(textView : TextView,text : Int){
                      var text = text.toString()
                      textView.text = text
                }
        }

}