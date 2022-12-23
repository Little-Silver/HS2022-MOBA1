package ch.zhaw.assignment_08

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Stock::class),
    version = 1, exportSchema = false)

abstract class StockAppDatabase : RoomDatabase() {
    abstract fun stockDao(): StockDao
}
