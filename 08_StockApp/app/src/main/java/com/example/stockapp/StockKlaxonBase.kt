package com.example.stockapp

import com.beust.klaxon.Json

class StockKlaxonBase(@Json(name = "Global Quote") val globalQuote : StockKlaxon)