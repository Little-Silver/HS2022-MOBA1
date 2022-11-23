package com.example.NineMensMorris

import com.example.ninemensmorris.Board
import com.example.ninemensmorris.Placeholder
import com.example.ninemensmorris.State

class Game {

    var board:Board = Board();
    var state:GameState = GameState.PLACEMENT
    var player1:Player = Player(State.BLACK)
    var player2:Player = Player(State.WHITE)
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

    private fun isLineComplete(corner: Placeholder, adjacentField: Placeholder): Boolean {
        if (!inSameLine(corner, adjacentField)) return false

        var lastVal = board.graph.adjacencyMap[adjacentField]?.filter { it.id != corner.id && it.isCorner }
        if (lastVal == null || lastVal.size != 1) return false
        return inSameLine(lastVal[0], adjacentField)

    }

    private fun inSameLine(placeholder: Placeholder, field: Placeholder): Boolean {
        var norm:Int = kotlin.math.min(
            1,
            kotlin.math.abs(placeholder.id[0].digitToInt() - field.id[0].digitToInt())
        )
        norm += kotlin.math.min(
            1,
            kotlin.math.abs(placeholder.id[1].digitToInt() - field.id[1].digitToInt())
        )
        norm += kotlin.math.min(
            1,
            kotlin.math.abs(placeholder.id[2].digitToInt() - field.id[2].digitToInt())
        )
        return norm == 1
    }

    private fun switchPlayer() {
        if (currentPlayer == player1) currentPlayer = player2
        else currentPlayer = player1
    }

    fun isFinished(): Boolean {
        //TODO: Check if movement is possible
        //TODO: Check if number of player stones < 4
        return true
    }
}