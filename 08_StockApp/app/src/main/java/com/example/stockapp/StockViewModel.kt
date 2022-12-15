package com.example.stockapp

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StockViewModel : ViewModel() {
    var stocks = MutableLiveData<MutableList<Stock>>()

    init {
        stocks.value = mutableListOf()
    }

    fun addStock(name: String, symbol: String, value: Double, context: Context){
        stocks.value?.add(Stock(name,symbol,value))
        stocks.postValue(stocks.value!!.toMutableList())
        val settings = context.getSharedPreferences("preferences-file", Context.MODE_PRIVATE)
        val editor = settings.edit()
        editor.putString(name,value.toString())
        editor.commit()
    }

    fun loadStock(context: Context){
        val settings = context.getSharedPreferences("preferences-file", Context.MODE_PRIVATE)
        settings.edit()
        val allEntries: Map<String, *> = settings.all as Map<String, *>
        Log.e("where is my key: ", allEntries.toString())
        for((key, value) in allEntries){
            Log.e("where is my key: ", key)
            stocks.value!!.add(Stock(key,key,value.toString().toDouble()))
            stocks.postValue(stocks.value!!.toMutableList())
        }
        stocks.value = mutableListOf()
    }
}