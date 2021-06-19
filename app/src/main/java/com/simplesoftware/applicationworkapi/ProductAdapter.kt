package com.simplesoftware.applicationworkapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.simplesoftware.applicationworkapi.model.Product

class ProductAdapter(
    private val context: Context,
    private val productList: List<Product>
    ): RecyclerView.Adapter<ProductViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false))

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.prodName.text = productList[position].prName
        holder.prodPrice.text = productList[position].prPrice

        Glide.with(context).load(productList[position].prImage).into(holder.productImage)

    }

    override fun getItemCount(): Int = productList.size

}

class ProductViewHolder(itemView: View): RecyclerView.ViewHolder (itemView){

    val productImage: ImageView = itemView.findViewById(R.id.prod_image)
    val prodName: TextView = itemView.findViewById(R.id.prod_name)
    val prodPrice: TextView = itemView.findViewById(R.id.prod_price)


}