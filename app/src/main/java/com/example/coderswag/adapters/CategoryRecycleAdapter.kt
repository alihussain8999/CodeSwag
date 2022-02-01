package com.example.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.R
import com.example.coderswag.model.Category

class CategoryRecycleAdapter(val context : Context, val categories : List<Category>, val itemClick : (Category) -> Unit) : RecyclerView.Adapter<CategoryRecycleAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
     val view = LayoutInflater.from(context).inflate(R.layout.category_list_item,parent,false)
        return MyViewHolder(view,itemClick)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindCategory(context,categories[position])
    }

    override fun getItemCount(): Int {
        return categories.count()
    }


    inner class MyViewHolder(itemView : View, val itemClick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView){
        var titleView : TextView? =itemView.findViewById(R.id.categoryName)
        var imageView : ImageView?=itemView.findViewById(R.id.categoryImage)

        fun bindCategory(context: Context , category: Category){
            titleView?.text = category.title
            val resourseId=context.resources.getIdentifier(category.image,"drawable",context.packageName)
            imageView?.setImageResource(resourseId)
            itemView.setOnClickListener { itemClick(category) }

        }
    }

}