package com.example.stockapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.stockapp.databinding.StockCellLayoutBinding

class StockAdapter(var stocks: MutableList<Stock>, val context: Context): BaseAdapter() {
    var layoutInflater: LayoutInflater
    private var _binding: StockCellLayoutBinding? = null
    private val binding get() = _binding!!
    private var bindings = mutableMapOf<View, StockCellLayoutBinding>()

    init{
        layoutInflater = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        //number of elements to display
        return stocks.size
    }

    override fun getItem(index: Int): Stock {
        //item at index
        return stocks.get(index)
    }

    override fun getItemId(index: Int): Long {
        //itemId for index
        return index.toLong()
    }

    override fun getView(index: Int, oldView: View?, viewGroup: ViewGroup?): View {
        var view : View
        if (oldView == null) { //check if we get a view to recycle
            _binding = StockCellLayoutBinding.inflate(layoutInflater, viewGroup, false)
            view = binding.root;
            bindings[binding.root] = binding
        }
        else { //if yes, use the oldview
            view = oldView
            _binding = bindings[view]
        }
        val stock = getItem(index) //get the data for this index
        binding.symbol.text = stock.symbol
        binding.price.text = stock.price.toString()
        return view
    }
}
