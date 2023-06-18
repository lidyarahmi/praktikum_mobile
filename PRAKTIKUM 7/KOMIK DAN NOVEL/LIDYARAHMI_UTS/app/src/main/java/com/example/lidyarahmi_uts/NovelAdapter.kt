package com.example.lidyarahmi_uts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NovelAdapter(private val novelList: List<DataNovel>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<NovelAdapter.ItemViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(novel: DataNovel)
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val novelImage: ImageView = itemView.findViewById(R.id.title_image2)
        val novelName: TextView = itemView.findViewById(R.id.heading2)
        val novelAuthor: TextView = itemView.findViewById(R.id.subheading2)
        val novelGenre: TextView = itemView.findViewById(R.id.detail2)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(novelList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item2, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = novelList[position]



        holder.novelImage.setImageResource(currentItem.gambarDetail2)
        holder.novelName.text = currentItem.judul2
        holder.novelAuthor.text = currentItem.author2
        holder.novelGenre.text = currentItem.detail2
    }

    override fun getItemCount(): Int {
        return novelList.size
    }
}
