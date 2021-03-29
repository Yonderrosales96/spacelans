package com.test.spacelens.network

import com.test.spacelens.model.responses.ProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoints {


    @GET("test/products_list.php")
    suspend fun getListOfProducts(@Query("latitude") latitude : Double, @Query("longitude") longitude : Double) : Response<ProductResponse>

}