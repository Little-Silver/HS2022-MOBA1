package com.example.ninemensmorris

data class Player(val color: State) {
    val INITIAL_NUMBER_OF_STONES: Int = 9
    var stonesToPlace:Int = INITIAL_NUMBER_OF_STONES;
    var stonesOnBoard:Int = 0
    var playerState: PlayerState = PlayerState.PLACEMENT
    var placedStones: Set<Placeholder> = setOf()
}

enum class PlayerState {
    PLACEMENT, JUMPING, MOVING
}
