package com.test.spacelens.repository

import com.test.spacelens.model.Products

interface ListProductRepository {

    suspend fun getListOfProducts(latitude : Double, longitude : Double) : List<Products>


}