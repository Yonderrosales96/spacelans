package com.test.spacelens.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.test.spacelens.R
import com.test.spacelens.adapter.RecyclerVIewProductAdapter
import com.test.spacelens.databinding.FragmentListOfferFragmentsBinding
import com.test.spacelens.model.Products
import com.test.spacelens.utils.LoadingDialog
import com.test.spacelens.utils.setLightStatusBar
import com.test.spacelens.viewmodel.ListProductViewModel
import kotlinx.android.synthetic.main.fragment_list_offer_fragments.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.KoinComponent

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListOfferFragments.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListOfferFragments : Fragment(),KoinComponent {

    private val producViewModel : ListProductViewModel by viewModel()
    private lateinit var binding : FragmentListOfferFragmentsBinding
    private lateinit var listOfProducts : List<Products>
    private lateinit var loadingDialog: LoadingDialog


    override fun onCreateView(
        inflater: LayoutInflater, @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_list_offer_fragments,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setLightStatusBar()
        loadingDialog = LoadingDialog(requireContext())
        producViewModel.getProductsAsync(1.0,1.0)
        binding.ivMaps.setOnClickListener {
            findNavController().navigate(ListOfferFragmentsDirections.actionListOfferFragmentsToMapsFragment(listOfProducts.toTypedArray()))
        }

        observe()
    }

    private fun observe() {
        producViewModel.run {
            products.observe(viewLifecycleOwner, Observer { it ->
                listOfProducts = it
                recycler.adapter = RecyclerVIewProductAdapter(it,onClick = {
                    findNavController().navigate(ListOfferFragmentsDirections.actionListOfferFragmentsToDetailFragment(it))
                })
            })
            onError.observe(viewLifecycleOwner, Observer {

            })
            loadingState.observe(viewLifecycleOwner, Observer {
                if (it)
                    loadingDialog.show()
                else
                    loadingDialog.dismiss()
            })
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment ListOfferFragments.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            ListOfferFragments()
    }
}