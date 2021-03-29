package com.test.spacelens.di

import com.test.spacelens.network.ApiClient
import com.test.spacelens.repository.ListProductRepository
import com.test.spacelens.repository.ListProductRepositoryImpl
import com.test.spacelens.viewmodel.ListProductViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {

    single{ApiClient.invoke()}
    single<ListProductRepository>{ListProductRepositoryImpl(get())}
    viewModel { ListProductViewModel(get()) }




}