package com.example.ppab_recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ppab_recycleview.databinding.ItemFigureBinding

typealias onClickFigure = (Figure) -> Unit

class FigureAdapter(
    private val listFigure: List<Figure>,
    private val onClickFigure: onClickFigure) :

    RecyclerView.Adapter<FigureAdapter.ItemFigureViewHolder>(){

    inner class ItemFigureViewHolder
        (private val binding: ItemFigureBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Figure) {

            Glide.with(binding.root.context)
                .load(data.imageURL)
                .fitCenter()
                .into(binding.gambarUrl)
            with(binding) {
                txtFigureName.text = data.nameFigure
                txtFigurePrice.text = data.priceFigure
                itemView.setOnClickListener {
                    onClickFigure(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFigureViewHolder {
        val binding = ItemFigureBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ItemFigureViewHolder(binding)
    }

    override fun getItemCount(): Int = listFigure.size

    override fun onBindViewHolder(holder: ItemFigureViewHolder, position: Int) {
        holder.bind(listFigure[position])
    }
}