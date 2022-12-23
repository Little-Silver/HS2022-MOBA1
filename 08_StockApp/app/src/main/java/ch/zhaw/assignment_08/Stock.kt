package ch.zhaw.assignment_08

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Stock(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "stock_name") val name: String?,
    @ColumnInfo(name = "stock_symbol") val symbol: String?,
    @ColumnInfo(name = "stock_value") var value: Double?)