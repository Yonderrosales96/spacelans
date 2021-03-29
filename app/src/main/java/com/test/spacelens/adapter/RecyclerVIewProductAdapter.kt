package com.test.spacelens.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.test.spacelens.R
import com.test.spacelens.databinding.ProductItemBinding
import com.test.spacelens.model.Products
class RecyclerVIewProductAdapter(val list : List<Products>,private val onClick : (product : Products) -> Unit = {_-> }) : RecyclerView.Adapter<RecyclerVIewProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val view : ProductItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.product_item,parent,false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        holder.actView(list[position])
    }

    inner class ProductViewHolder(private val productItemBinding: ProductItemBinding) : RecyclerView.ViewHolder(productItemBinding.root) {

        fun actView(products: Products){
            productItemBinding.producto = products
            productItemBinding.root.setOnClickListener { onClick.invoke(products) }
        }

    }

}