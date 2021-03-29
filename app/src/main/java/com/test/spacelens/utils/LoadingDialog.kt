package com.test.spacelens.utils

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.test.spacelens.R

class LoadingDialog(context : Context) : Dialog(context){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading)
        this.window?.setBackgroundDrawableResource(android.R.color.transparent)


    }
}