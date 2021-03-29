package com.test.spacelens.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.test.spacelens.R
import com.test.spacelens.databinding.GalleryItemBinding
import com.test.spacelens.model.Gallery
import com.test.spacelens.model.Products

class GalleryAdapter(private val gallery: List<Gallery>,private val onClick : (gallery : Gallery) -> Unit = { _-> }) : RecyclerView.Adapter<GalleryAdapter.GalleryItem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryItem {
        val galleryItemBinding : GalleryItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.gallery_item,parent,false)
        return GalleryItem(galleryItemBinding)
    }

    override fun getItemCount(): Int {
        return gallery.size
    }

    override fun onBindViewHolder(holder: GalleryItem, position: Int) {
        holder.actView(gallery[position])
    }

    inner class GalleryItem(val galleryItemBinding: GalleryItemBinding) : RecyclerView.ViewHolder(galleryItemBinding.root){

        fun actView(gallery: Gallery){
            galleryItemBinding.image = gallery.src
            galleryItemBinding.root.setOnClickListener {
                onClick.invoke(gallery)
            }
        }

    }

}