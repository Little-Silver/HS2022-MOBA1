package com.example.ninemensmorris

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    var board: Board = Board();
    var lines: MutableSet<Set<Placeholder>> = mutableSetOf()

    @Test
    fun isBoardEmpty() {
        for (element in board.graph.elements) {
            assertEquals(element.state, State.EMPTY)
        }
    }

    @Test
    fun checkGetLines() {
        var lines = board.getLines(board.p000)
        var expectedLines = setOf<Set<Placeholder>>(setOf(board.p000, board.p001, board.p002), setOf(board.p000, board.p010, board.p020))
        assertTrue(lines.size == 2)
        assertTrue(lines.containsAll(expectedLines))
    }

    @Test
    fun isLineComplete() {

        initLines()
        for (line in lines) {
            for (placeholder in line) {
                placeholder.state = State.BLACK
            }
            var s:String = line.toString()
            for (placeholder in line) {
                assertEquals("Line: " + s + ", Field: " + placeholder.id, 1, board.countCompletedLines(placeholder))
            }

            for (placeholder in line) {
                placeholder.state = State.EMPTY
            }
        }
    }

    fun initLines() {
        lines.add(setOf(board.p000, board.p001, board.p002))
        lines.add(setOf(board.p000, board.p010, board.p020))
        lines.add(setOf(board.p020, board.p021, board.p022))
        lines.add(setOf(board.p002, board.p012, board.p022))

        lines.add(setOf(board.p100, board.p101, board.p102))
        lines.add(setOf(board.p100, board.p110, board.p120))
        lines.add(setOf(board.p120, board.p121, board.p122))
        lines.add(setOf(board.p102, board.p112, board.p122))

        lines.add(setOf(board.p200, board.p201, board.p202))
        lines.add(setOf(board.p200, board.p210, board.p220))
        lines.add(setOf(board.p220, board.p221, board.p222))
        lines.add(setOf(board.p202, board.p212, board.p222))

        lines.add(setOf(board.p001, board.p101, board.p201))
        lines.add(setOf(board.p010, board.p110, board.p210))
        lines.add(setOf(board.p021, board.p121, board.p221))
        lines.add(setOf(board.p012, board.p112, board.p212))
    }

    fun getById(id:String): Placeholder? {
        for (element in board.graph.elements) {
            if (id == element.id) {
                return element
            }
        }
        return null
    }
}