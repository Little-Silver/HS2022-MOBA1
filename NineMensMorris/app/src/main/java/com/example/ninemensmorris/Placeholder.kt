package com.example.ninemensmorris

public data class Placeholder(val id: String, val isCorner: Boolean) {
    private val state: State = State.EMPTY
}

enum class State {
    EMPTY, WHITE, BLACK
}