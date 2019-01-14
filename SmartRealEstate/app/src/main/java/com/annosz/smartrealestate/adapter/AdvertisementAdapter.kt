package com.annosz.smartrealestate.adapter

import android.app.PendingIntent.getActivity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.annosz.smartrealestate.R
import com.annosz.smartrealestate.model.AdvertisementData
import kotlinx.android.synthetic.main.fragment_add_house.view.*
import kotlinx.android.synthetic.main.item_house.view.*

class AdvertisementAdapter : RecyclerView.Adapter<AdvertisementAdapter.AdvertisementViewHolder>() {

    private val adList = mutableListOf<AdvertisementData>()

    var itemClickListener: AdvertisementItemClickListener? = null

    lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdvertisementViewHolder {
        context = parent.context

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_house, null)
        return AdvertisementViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdvertisementViewHolder, position: Int) {
        val ad = adList[position]

        if (ad.image != null) {
            holder.adImage.setImageBitmap(BitmapFactory.decodeByteArray(ad.image, 0, ad.image!!.size))
        }
        holder.adPrice.text = context.getString(R.string.list_price_quantity, ad.priceCreatedAt.toString())
        holder.adCity.text = ad.city
        holder.ad = ad
    }

    override fun getItemCount(): Int {
        return adList.size
    }

    fun setAds(ads: List<AdvertisementData>) {
        adList.clear()
        adList += ads
        notifyDataSetChanged()
    }

    fun getAds() : List<AdvertisementData> {
        return adList
    }

    inner class AdvertisementViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var adImage: ImageView = itemView.list_house_picture
        var adPrice: TextView = itemView.list_price
        var adCity: TextView = itemView.list_city

        var ad: AdvertisementData? = null

        init {
            itemView.setOnClickListener {
                ad?.let { itemClickListener?.onItemClick(it) }
            }
        }
    }

    interface AdvertisementItemClickListener {
        fun onItemClick(ad: AdvertisementData)
    }
}