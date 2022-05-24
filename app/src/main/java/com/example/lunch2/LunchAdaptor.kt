package com.example.lunch2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lunch2.databinding.ItemLunchBinding

class LunchAdapter : ListAdapter<Row, LunchAdapter.LunchViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LunchViewHolder {
        val binding = ItemLunchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LunchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LunchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class LunchViewHolder(private val binding: ItemLunchBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Row) {
            with(binding) {
                tvName.text = item.dDISHNM
                tvType.text = item. mLSVTOYMD
                tvPhone.text = item.mLSVFROMYMD
                tvAddr.text = item.mMEALSCCODE
                tvWgs84lat.text = item.mMEALSCNM
                tvWgs84lon.text = item.nTRINFO
            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Row>() {
            override fun areItemsTheSame(oldItem: Row, newItem: Row): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(oldItem: Row, newItem: Row): Boolean {
                return oldItem == newItem
            }
        }
    }
}