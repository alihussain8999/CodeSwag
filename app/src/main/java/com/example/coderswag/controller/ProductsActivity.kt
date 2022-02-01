package com.example.coderswag.controller

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coderswag.R
import com.example.coderswag.adapters.ProductsAdapter
import com.example.coderswag.services.DataService
import com.example.coderswag.utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {
    lateinit var productAdapter: ProductsAdapter;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        if(categoryType!=null) {
             productAdapter = ProductsAdapter(this, DataService.getProducts(categoryType))
            var spanCount = 2
            val orientation = resources.configuration.orientation
            if(orientation == Configuration.ORIENTATION_LANDSCAPE){
                spanCount=2
            }else{
                spanCount=3
            }
            val layoutManager =GridLayoutManager(this,spanCount)
            productListView.layoutManager=layoutManager
            productListView.adapter=productAdapter


        }

    }
}