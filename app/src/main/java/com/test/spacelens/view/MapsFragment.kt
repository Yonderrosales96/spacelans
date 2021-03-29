package com.test.spacelens.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.ClusterManager
import com.test.spacelens.R
import com.test.spacelens.model.Products
import com.test.spacelens.utils.CustomInfoWindowAdapter
import com.test.spacelens.utils.ItemCluster

class MapsFragment : Fragment() {

    val args : MapsFragmentArgs by navArgs()
    lateinit var listOfProducts : Array<Products>
    private var clusterManager: ClusterManager<ItemCluster>? = null

    private var map: GoogleMap? = null
    private val markersOptions: MutableList<MarkerOptions>? = mutableListOf()

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        map = googleMap
        listOfProducts = args.productos
        setUpClusters()
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    private fun setUpClusters(){

        clusterManager = ClusterManager(context,map)
        map?.setOnCameraIdleListener(clusterManager)
        map?.setOnMarkerClickListener(clusterManager)
        val c = CustomInfoWindowAdapter(requireContext())
        map?.setInfoWindowAdapter(c)
        map?.setOnInfoWindowClickListener(clusterManager)
        clusterManager!!.markerCollection.setInfoWindowAdapter(c)

        clusterManager!!.setOnClusterItemInfoWindowClickListener {
            findNavController().navigate(MapsFragmentDirections.actionMapsFragmentToDetailFragment(it.products))
        }

        setMarkers()

    }

    private fun setMarkers() {

        map?.clear()
        listOfProducts.forEach {
            val itemCluster = ItemCluster(it.location.latitude,it.location.longitude,it.title,it.attachment.url,it)
            clusterManager?.addItem(itemCluster)
        }

    }
}