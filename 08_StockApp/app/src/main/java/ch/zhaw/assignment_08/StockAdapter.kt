package ch.zhaw.assignment_08

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class StockAdapter(val list : MutableList<Stock>, val firstFragment: FirstFragment) : RecyclerView.Adapter<StockViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return StockViewHolder(inflater, parent, firstFragment)
    }

    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
        val movie: Stock = list[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = list.size
}