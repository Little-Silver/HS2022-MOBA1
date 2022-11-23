package com.example.ninemensmorris

data class Placeholder(val id: String, val isCorner: Boolean) {
    var state: State = State.EMPTY
}

enum class State {
    EMPTY, WHITE, BLACK
}