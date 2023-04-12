package com.example.mobileappcw2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LanguageAdapter(var mList: List<LanguageData>) :
    RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {

    inner class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val suggestionsImage : ImageView = itemView.findViewById(R.id.suggestionsTv)
        val titleTv : TextView = itemView.findViewById(R.id.titleTv)
        val heartIcon : ImageView = itemView.findViewById(R.id.heart)

        init {
            heartIcon.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    mList[position].toggleLike()
                    notifyItemChanged(position)
                }
            }
        }
    }

    fun setFilteredList(mList: List<LanguageData>){
        this.mList = mList
        notifyDataSetChanged()
    }

    var onHeartIconClickListener: ((language: LanguageData) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item_vertical , parent , false)
        return LanguageViewHolder(view)
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.suggestionsImage.setImageResource(mList[position].picture)
        holder.titleTv.text = mList[position].title
        holder.heartIcon.setImageResource(
            if (mList[position].isLiked) R.drawable.heart_filled else R.drawable.heart_outline
        )
        holder.heartIcon.setOnClickListener {
            mList[position].isLiked = !mList[position].isLiked
            holder.heartIcon.setImageResource(
                if (mList[position].isLiked) R.drawable.heart_filled else R.drawable.heart_outline
            )
            onHeartIconClickListener?.invoke(mList[position])
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}
