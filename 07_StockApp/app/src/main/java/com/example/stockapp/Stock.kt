package com.example.stockapp

import com.beust.klaxon.Json

class Stock(
    @Json(name = "01. symbol")
    var symbol: String,
    @Json(name = "05. price")
    var price: String
) {}