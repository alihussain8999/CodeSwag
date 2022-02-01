package com.example.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.coderswag.R
import com.example.coderswag.model.Category

class CustomAdapter(val context: Context, private val categories: List<Category>) : BaseAdapter(){
    override fun getCount(): Int {
        return categories.count()
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
       val categoryView : View
       categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item,null)

        val titleView = categoryView.findViewById<TextView>(R.id.categoryName)
        val imageView = categoryView.findViewById<ImageView>(R.id.categoryImage)

        titleView.text = categories[position].title
        val resourseId=context.resources.getIdentifier(categories[position].image,"drawable",context.packageName)
        imageView.setImageResource(resourseId)

        return categoryView
    }
}