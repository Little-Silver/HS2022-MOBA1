package com.example.ninemensmorris

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import java.util.HashSet

class Game {

    var board: Board = Board();
    var state: GameState = GameState.PLACEMENT
    var player1: Player = Player(State.BLACK)
    var player2: Player = Player(State.WHITE)
    var steal: Int = 0
    var winner: State = State.EMPTY
    var error: String = ""

    var currentPlayer = player1

    constructor(board: Board) {
        this.board = board
        this.state = GameState.PLACEMENT
        this.player1 = Player(State.BLACK)
        this.player2 = Player(State.WHITE)
        this.currentPlayer = player1
    }

    fun move(placeholderList: MutableList<Placeholder>) {
        error = ""
        if (steal > 0) {
            try {
                removeStone(placeholderList[0])
                steal -= 1
                if (isFinished()) {
                    winner = currentPlayer.color
                }
                if (steal == 0) switchPlayer()
            } catch (e: Exception) {
                error = e.message.toString()
            } finally {
                placeholderList.removeAt(0)
            }

        } else {
            when (currentPlayer.playerState) {
                PlayerState.PLACEMENT -> {
                    try {
                        addStone(placeholderList[0])

                    } catch (e: Exception) {
                        error = e.message.toString()
                    } finally {
                        placeholderList.removeAt(0)
                    }
                }

                PlayerState.JUMPING, PlayerState.MOVING  -> {
                    if (placeholderList.size == 2) {
                        try {
                            moveStone(placeholderList[0], placeholderList[1], currentPlayer.playerState == PlayerState.JUMPING)
                        } catch (e: Exception) {
                            error = e.message.toString()
                        } finally {
                            placeholderList.removeAt(1)
                            placeholderList.removeAt(0)
                        }
                    }
                }

            }
        }

    }

    @Throws
    fun addStone(placeholder: Placeholder) {
        if (placeholder.state != State.EMPTY) {
            throw java.lang.Exception("Invalid Move <AddStone>: Field is not empty")
        }

        currentPlayer.stonesToPlace -= 1
        addStoneToBoard(placeholder, currentPlayer)

        steal += countCompletedLines(placeholder)

        if (currentPlayer.stonesToPlace == 0) {
            currentPlayer.playerState = PlayerState.MOVING
        }

        if (isFinished()) {
            winner = currentPlayer.color
        }
        if (steal == 0) switchPlayer()
    }

    @Throws
    fun removeStone(placeholder: Placeholder) {

        if (placeholder.state == currentPlayer.color) {
            throw java.lang.Exception("Invalid Move <removeStone>: Can't remove your own stones")
        }

        if (placeholder.state == State.EMPTY) {
            throw java.lang.Exception("Invalid Move <removeStone>: No stone to remove")
        }

        if (countCompletedLines(placeholder) > 0) {
            throw java.lang.Exception("Invalid Move <removeStone>: Can't remove stones in completed line")
        }

        val otherPlayer = getOtherPlayer()

        removeStoneFromBoard(placeholder, otherPlayer)

        if (otherPlayer.playerState == PlayerState.MOVING && otherPlayer.stonesOnBoard == 3) {
            otherPlayer.playerState = PlayerState.JUMPING
        }
    }

    @Throws
    fun moveStone(from: Placeholder, to: Placeholder, jump: Boolean) {
        if (to.state != State.EMPTY)
            throw java.lang.Exception("Invalid Move <MoveStone>: Destination field already in use")
        if (from.state != currentPlayer.color)
            throw java.lang.Exception("Invalid Move <MoveStone>: Only own stones can be moved")
        if (board.graph.adjacencyMap[from]?.contains(to) != true && !jump)
            throw java.lang.Exception("Invalid Move <MoveStones>: Jumping is not allowed")

        removeStoneFromBoard(from, currentPlayer)
        addStoneToBoard(to, currentPlayer)

        steal += countCompletedLines(to)

        if (isFinished()) winner = currentPlayer.color
        if (steal == 0) switchPlayer()
    }

    private fun addStoneToBoard(stone: Placeholder, player: Player) {
        player.placedStones.add(stone)
        player.stonesOnBoard += 1
        stone.state = player.color
    }

    private fun removeStoneFromBoard(stone: Placeholder, player: Player) {
        player.placedStones.remove(stone)
        player.stonesOnBoard -= 1
        stone.state = State.EMPTY
    }

    private fun countCompletedLines(placeholder: Placeholder): Int {
        val adjacentFieldsWithSameStone =
            board.graph.adjacencyMap[placeholder]?.filter { it.state == placeholder.state }

        var completeLines: Int = 0

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

        var lastVal =
            board.graph.adjacencyMap[adjacentField]?.filter { it.id != corner.id && it.isCorner }
        if (lastVal == null || lastVal.size != 1 || lastVal[0].state != corner.state) return false
        return inSameLine(lastVal[0], adjacentField)

    }

    private fun inSameLine(placeholder: Placeholder, field: Placeholder): Boolean {
        var norm: Int = kotlin.math.min(
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

    fun switchPlayer() {
        if (currentPlayer == player1) currentPlayer = player2
        else currentPlayer = player1
    }

    fun isFinished(): Boolean {
        if (player1.stonesOnBoard + player1.stonesToPlace < 3 || player2.stonesOnBoard + player2.stonesToPlace < 3) {
            return true
        }
        val otherPlayer = getOtherPlayer()
        if (otherPlayer.playerState != PlayerState.PLACEMENT) {
            for (placedStone in getOtherPlayer().placedStones) {
                val adjacent =
                    board.graph.adjacencyMap[placedStone]?.filter { placeholder -> placeholder.state == State.EMPTY }
                if (adjacent != null && adjacent.isNotEmpty()) {
                    return false;
                }
            }
            return true;
        } else {
            return false
        }

    }

    fun getOtherPlayer(): Player {
        var otherPlayer = player1
        if (currentPlayer == player1) otherPlayer = player2
        return otherPlayer
    }
}