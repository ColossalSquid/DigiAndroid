package com.example.digiandroid.ui.main.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.digiandroid.R
import com.example.digiandroid.databinding.CategoryRowBinding
import com.example.digiandroid.models.Category
import java.util.*

class CategoryAdapter(category: List<Category>): RecyclerView.Adapter<CategoryVH>() {

    lateinit var binding: CategoryRowBinding
    var categoryList = category

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryVH {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.category_row, null,true)
        return CategoryVH(binding)
    }

    override fun onBindViewHolder(holder: CategoryVH, position: Int) {
        var category = categoryList.get(position)
        binding.category = category
    }

    override fun getItemCount(): Int {
       return categoryList.size
    }


    companion object {
        @JvmStatic
        @BindingAdapter("categoryImage")
        fun showImage(image: AppCompatImageView, url : String) {
        Glide.with(image.context).load(url).into(image)
        }
    }
}