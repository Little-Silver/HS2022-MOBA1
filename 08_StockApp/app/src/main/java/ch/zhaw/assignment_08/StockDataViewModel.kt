package ch.zhaw.assignment_08

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room

class StockDataViewModel() : ViewModel() {
    val stocks = MutableLiveData<MutableList<Stock>>(mutableListOf())
    lateinit var db : StockAppDatabase

    init {
    }

    fun initDatabase(context: Context) {
        db = Room.databaseBuilder(
            context,
            StockAppDatabase::class.java, "database-name"
        ).build()
    }

    suspend fun insertStocks(stock: Stock) {
        db.stockDao().insertAll(
            Stock(name=stock.name, symbol=stock.symbol, value=stock.value))
    }
    suspend fun readStocks() {
        //we are in a background thread and need to call postValue
        stocks.postValue(db.stockDao().getAll().toMutableList())
    }
}
