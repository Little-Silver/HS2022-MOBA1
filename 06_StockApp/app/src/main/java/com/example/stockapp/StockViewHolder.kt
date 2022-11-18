package com.example.stockapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StockViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(
  R.layout.stock_cell_layout, parent, false)) {

    private var nameView: TextView? = null
    private var symbolView: TextView? = null
    private var valueView: TextView? = null

    init {
        nameView = itemView.findViewById(R.id.name)
        symbolView = itemView.findViewById(R.id.symbol)
        valueView = itemView.findViewById(R.id.value)
    }
    fun bind(stock: Stock){
        nameView?.text = stock.name
        symbolView?.text = stock.symbol
        valueView?.text = stock.value.toString()
    }
}