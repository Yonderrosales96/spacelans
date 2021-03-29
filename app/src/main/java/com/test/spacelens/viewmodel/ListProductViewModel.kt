package com.test.spacelens.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.spacelens.model.Products
import com.test.spacelens.repository.ListProductRepository
import kotlinx.coroutines.launch

class ListProductViewModel(private val listProductRepository: ListProductRepository) : BaseViewModel() {

    var products = MutableLiveData<List<Products>>()

    fun getProductsAsync(latitude : Double, longitude : Double){
        viewModelScope.launch {
            loadingState.postValue(true)
            getProducts(latitude,longitude)
        }
    }

    private suspend fun getProducts(latitude: Double,longitude: Double){

        kotlin.runCatching {
            listProductRepository.getListOfProducts(latitude,longitude)
        }.run {
            loadingState.postValue(false)
            onSuccess {
                products.postValue(it)
            }
            onFailure {
                onError.postValue(it.toString())
            }
        }



    }



}