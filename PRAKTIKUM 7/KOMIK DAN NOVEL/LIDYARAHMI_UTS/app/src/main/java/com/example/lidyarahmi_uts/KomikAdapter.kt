package com.example.lidyarahmi_uts

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class KomikAdapter(private val komikList: List<DataKomik>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<KomikAdapter.ItemViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(Data: DataKomik)
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val komikImage: ImageView = itemView.findViewById(R.id.title_image)
        val komikName: TextView = itemView.findViewById(R.id.heading)
        val komikAuthor : TextView = itemView.findViewById(R.id.subheading)
        val komikGenre : TextView = itemView.findViewById(R.id.detail)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(komikList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = komikList[position]
        holder.komikImage.setImageResource(currentItem.gambarDetail)
        holder.komikName.text = currentItem.judul
        holder.komikGenre.text = currentItem.detail
        holder.komikAuthor.text = currentItem.author
    }

    override fun getItemCount(): Int {
        return komikList.size
    }
}
