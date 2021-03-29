package com.test.spacelens.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.koin.core.KoinComponent
import java.lang.StringBuilder

open class BaseViewModel : ViewModel(),KoinComponent {

    val loadingState = MutableLiveData<Boolean>()
    val onError = MutableLiveData<String>()

    protected fun showLoading() = loadingState.postValue(true)

    protected fun dismissLoading() = loadingState.postValue(false)

    fun logError(throwable: Throwable?) {
        Log.d("${this::class.java.canonicalName} ERROR", throwable?.message.toString())
    }


}