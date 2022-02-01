package com.example.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.R
import com.example.coderswag.model.Product

class ProductsAdapter(val context : Context,val products : List<Product> ) : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view =LayoutInflater.from(context).inflate(R.layout.product_list_item,parent,false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindView(context,products[position])
    }

    override fun getItemCount(): Int {
      return products.count()
    }

    inner class ProductViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
            val productImage =itemView.findViewById<ImageView>(R.id.productImage)
            val productName = itemView.findViewById<TextView>(R.id.productText)
            val productAmount = itemView.findViewById<TextView>(R.id.productAmount)

        fun bindView(context: Context , product : Product){
            val resourceId = context.resources.getIdentifier(product.image,
            "drawable",context.packageName)
            productImage.setImageResource(resourceId)
            productName.text=product.title
            productAmount.text=product.price
        }
    }
}