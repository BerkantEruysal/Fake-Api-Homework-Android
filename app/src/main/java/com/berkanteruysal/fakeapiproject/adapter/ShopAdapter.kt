package com.berkanteruysal.fakeapiproject.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.berkanteruysal.fakeapiproject.R
import com.berkanteruysal.fakeapiproject.databinding.ItemShopBinding
import com.berkanteruysal.fakeapiproject.model.Shop
import com.berkanteruysal.fakeapiproject.util.downloadURL

class ShopAdapter(private var shopList: ArrayList<Shop>): RecyclerView.Adapter<ShopAdapter.ShopViewHolder>() {

    class ShopViewHolder(var view: ItemShopBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemShopBinding>(inflater, R.layout.item_shop,parent,false)

        return ShopViewHolder(view)
    }

    override fun getItemCount(): Int {
        return shopList.size
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        holder.view.shopTitle.text = shopList[position].title
        holder.view.shopPrice.text = shopList[position].price

        holder.view.shopImage.downloadURL(shopList[position].image)

    }

    @SuppressLint("NotifyDataSetChanged")
    fun  updateList(newList: List<Shop>){
        shopList = newList as ArrayList<Shop>
        notifyDataSetChanged()
    }
}