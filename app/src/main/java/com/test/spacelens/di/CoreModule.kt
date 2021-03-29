package com.test.spacelens.di

import org.koin.core.context.loadKoinModules

object CoreModule {

    private val modules = listOf(repositoryModule)
    fun init() = loadKoinModules(modules)

}