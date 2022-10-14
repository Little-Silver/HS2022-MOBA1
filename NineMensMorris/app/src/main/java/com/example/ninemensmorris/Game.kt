package com.example.NineMensMorris

import com.example.ninemensmorris.Board
import com.example.ninemensmorris.Placeholder
import com.example.ninemensmorris.State

class Game {

    var board:Board = Board();
    var state:GameState = GameState.PLACEMENT
    var player1: Player = Player(State.BLACK)
    var player2: Player = Player(State.WHITE)
    var currentPlayer = player1;

    fun addStone(placeholder: Placeholder, state:State) {
        //TODO: Update board
        placeholder.state = state
        val completedLines = countCompletedLines(placeholder)
        //TODO: select <completedLines> number of stones to be removed
    }

    fun removeStone(placeholder: Placeholder) {
        placeholder.state = State.EMPTY
        //TODO removeStone
    }

    fun moveStone(from: Placeholder, to:Placeholder) {
        //TODO: validate
    }

    private fun countCompletedLines(placeholder: Placeholder): Int {
        val adjacentFieldsWithSameStone = board.graph.adjacencyMap[placeholder]?.filter { it.state == placeholder.state }

        var completeLines:Int = 0

        if (adjacentFieldsWithSameStone == null || adjacentFieldsWithSameStone.isEmpty()) {
            return completeLines
        }

        if (placeholder.isCorner) {
            for (field in adjacentFieldsWithSameStone) {
                if (isLineComplete(placeholder, field)) {
                    completeLines++
                }
            }
        } else if (adjacentFieldsWithSameStone.size == 3) {
            completeLines += 1
        } else if (adjacentFieldsWithSameStone.size == 4) {
            completeLines += 2
        } else if (adjacentFieldsWithSameStone.size == 2) {
            if (inSameLine(adjacentFieldsWithSameStone[0], adjacentFieldsWithSameStone[1])) {
                completeLines += 1
            }
        }

        return completeLines
    }

    private fun isLineComplete(placeholder: Placeholder, field: Placeholder): Boolean {
        TODO("Not yet implemented")
    }

    private fun inSameLine(placeholder: Placeholder, field: Placeholder): Boolean {
        TODO("Not yet implemented")
    }

    private fun switchPlayer() {

    }

    fun isFinished(): Boolean {
        //TODO: Check if movement is possible
        //TODO: Check if number of player stones < 4
        return true
    }
}