package com.test.spacelens.repository

import com.test.spacelens.model.Products
import com.test.spacelens.network.ApiClient
import com.test.spacelens.network.Endpoints
import org.koin.core.KoinComponent
import org.koin.core.inject

class ListProductRepositoryImpl(private val api : Endpoints) : ListProductRepository,KoinComponent {


    override suspend fun getListOfProducts(latitude : Double, longitude : Double): List<Products> {

        val response = api.getListOfProducts(latitude,longitude)
        //LEFT TO VALIDATE
        return response.body()?.products!!
    }

}