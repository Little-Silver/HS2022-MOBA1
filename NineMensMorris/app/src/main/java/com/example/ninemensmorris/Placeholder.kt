package com.example.ninemensmorris

public data class Placeholder(val id: String, val isCorner: Boolean) {
    public var state: State = State.EMPTY
}

enum class State {
    EMPTY, WHITE, BLACK
}