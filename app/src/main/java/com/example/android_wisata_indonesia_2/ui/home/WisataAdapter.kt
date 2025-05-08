package com.example.android_wisata_indonesia_2.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_wisata_indonesia_2.R
import com.example.android_wisata_indonesia_2.model.Wisata

class WisataAdapter(
    private var list: List<Wisata>,
    private val onItemClick: (Wisata) -> Unit
) : RecyclerView.Adapter<WisataAdapter.WisataViewHolder>() {

    inner class WisataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.tvName)
        val locationTextView: TextView = itemView.findViewById(R.id.tvLocation)
        val descriptionTextView: TextView = itemView.findViewById(R.id.tvDescription)

        init {
            itemView.setOnClickListener {
                val item = list[adapterPosition]
                onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WisataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_wisata, parent, false)
        return WisataViewHolder(view)
    }

    override fun onBindViewHolder(holder: WisataViewHolder, position: Int) {
        val wisata = list[position]
        holder.nameTextView.text = wisata.name
        holder.locationTextView.text = wisata.location
        holder.descriptionTextView.text = wisata.description
    }

    override fun getItemCount(): Int = list.size

    fun updateData(newList: List<Wisata>) {
        list = newList
        notifyDataSetChanged()
    }
}
