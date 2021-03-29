package com.test.spacelens.utils

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem
import com.test.spacelens.model.Products

class ItemCluster(lat : Double, lon : Double, private val title: String,
                  private val snippet: String,val products: Products
) : ClusterItem {


    private val position: LatLng = LatLng(lat, lon)

    override fun getPosition(): LatLng {
        return position
    }

    override fun getSnippet(): String? {
        return snippet
    }

    override fun getTitle(): String? {
        return title
    }

}