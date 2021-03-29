package com.test.spacelens.utils

import android.app.Activity
import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import com.test.spacelens.R
import kotlinx.android.synthetic.main.info_window_custom.view.*

class CustomInfoWindowAdapter(private val context : Context) : GoogleMap.InfoWindowAdapter {

    private val view = (context as Activity).layoutInflater.inflate(R.layout.info_window_custom,null)

    override fun getInfoContents(p0: Marker?): View {
        view.title.text = p0?.title
        Glide.with(context)
            .setDefaultRequestOptions(
                RequestOptions()
                    .circleCrop()
            )
            .load(p0?.snippet)
            .into(view.image)
        return view
    }

    override fun getInfoWindow(p0: Marker?): View {
        view.title.text = p0?.title

        Glide.with(context)
            .setDefaultRequestOptions(
                RequestOptions()
                    .circleCrop()
            )
            .load(p0?.snippet)
            .into(view.image)
        return view
    }

}