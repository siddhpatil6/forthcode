package com.forthcode.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.forthcode.R
import com.forthcode.data.ForthCodePhotosItem
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso


class CustomAdapter(
    private val context: Context
) : ListAdapter<ForthCodePhotosItem, CustomAdapter.CustomViewHolder>(DiffCallback) {

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtTitle: TextView = itemView.findViewById(R.id.txtTitle)
        private val coverImage: ImageView = itemView.findViewById(R.id.ivThumbNail)

        fun bind(item: ForthCodePhotosItem) {
            txtTitle.text = item.title
            Picasso.Builder(context)
                .downloader(OkHttp3Downloader(context))
                .build()
                .load(item.thumbnailUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(coverImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.forthcode_item, parent, false)
        return CustomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<ForthCodePhotosItem>() {
            override fun areItemsTheSame(
                oldItem: ForthCodePhotosItem,
                newItem: ForthCodePhotosItem
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ForthCodePhotosItem,
                newItem: ForthCodePhotosItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
