package ch.zhaw.assignment_08

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StockViewHolder(inflater: LayoutInflater, parent: ViewGroup, firstFragment: FirstFragment):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.stock_cell, parent, false)) {

    private var nameView: TextView? = null
    private var valueView: TextView? = null
    private var updateButton: Button? = null
    private val listFragment: FirstFragment = firstFragment;

    init {
        nameView = itemView.findViewById(R.id.name)
        valueView = itemView.findViewById(R.id.value)
        updateButton = itemView.findViewById(R.id.updateStock)
    }

    fun bind(stock: Stock) {
        nameView?.text = stock.name
        valueView?.text = stock.value.toString()
        updateButton?.setOnClickListener {
            listFragment.callServer(stock)
        }
    }
}