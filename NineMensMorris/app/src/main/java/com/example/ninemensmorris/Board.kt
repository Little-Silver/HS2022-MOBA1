package com.example.ninemensmorris

import java.util.HashSet
import java.util.stream.Collectors

/**
 *
 */
class Board {

    val graph: Graph<Placeholder> = Graph()

    var p000 = Placeholder("000", true)
    var p001 = Placeholder("001", false)
    var p002 = Placeholder("002", true)
    var p010 = Placeholder("010", false)
    var p020 = Placeholder("020", true)
    var p012 = Placeholder("012", false)
    var p021 = Placeholder("021", false)
    var p022 = Placeholder("022", true)

    var p100 = Placeholder("100", true)
    var p110 = Placeholder("110", false)
    var p120 = Placeholder("120", true)
    var p101 = Placeholder("101", false)
    var p102 = Placeholder("102", true)
    var p112 = Placeholder("112", false)
    var p122 = Placeholder("122", true)
    var p121 = Placeholder("121", false)

    var p200 = Placeholder("200", true)
    var p201 = Placeholder("201", false)
    var p202 = Placeholder("202", true)
    var p210 = Placeholder("210", false)
    var p220 = Placeholder("220", true)
    var p221 = Placeholder("221", false)
    var p222 = Placeholder("222", true)
    var p212 = Placeholder("212", false)

    constructor() {

        graph.addEdgeBidirectional(p001, setOf(p000, p101, p002))
        graph.addEdgeBidirectional(p010, setOf(p000, p020, p110))
        graph.addEdgeBidirectional(p012, setOf(p002, p022, p112))
        graph.addEdgeBidirectional(p021, setOf(p020, p022, p121))

        graph.addEdgeBidirectional(p110, setOf(p010, p100, p120, p210))
        graph.addEdgeBidirectional(p101, setOf(p001, p100, p102, p201))
        graph.addEdgeBidirectional(p112, setOf(p012, p102, p122, p212))
        graph.addEdgeBidirectional(p121, setOf(p021, p120, p122, p221))

        graph.addEdgeBidirectional(p201, setOf(p200, p202, p101))
        graph.addEdgeBidirectional(p210, setOf(p200, p220, p110))
        graph.addEdgeBidirectional(p221, setOf(p222, p220, p121))
        graph.addEdgeBidirectional(p212, setOf(p222, p202, p112))
    }

    fun countCompletedLines(placeholder: Placeholder): Int {
        var completeLines = 0

        for (line in getLines(placeholder)) {
            if (isLineComplete(line)) completeLines++
        }

        return completeLines
    }

    private fun isLineComplete(line: Set<Placeholder>): Boolean {
        return line.stream().map { it::state.get() }.distinct().limit(2).count() <= 1
    }

    fun getLines(placeholder: Placeholder): Set<Set<Placeholder>> {
        val lines: MutableSet<MutableSet<Placeholder>> = mutableSetOf()

        var fields: MutableSet<Placeholder> = mutableSetOf(placeholder)

        getFields(placeholder, placeholder, fields)

        for (field in fields) {
            if (field != placeholder) {
                var line: MutableSet<Placeholder> = mutableSetOf()
                line.add(field)
                for (field2 in fields)
                {
                    if(inSameLine(field, field2)){
                        line.add(field2)
                    }
                }
                lines.add(line)
            }
        }

        return lines
    }

    private fun getFields(placeholder: Placeholder, current: Placeholder, fields: MutableSet<Placeholder>): MutableSet<Placeholder> {
        for (p1 in getAdjacentFields(current)!!) {
            if (inSameLine(p1, placeholder) && !fields.contains(p1)) {
                fields.add(p1)
                getFields(placeholder, p1, fields)
            }
        }
        return fields
    }

    private fun getAdjacentFields(placeholder: Placeholder): HashSet<Placeholder>? {
        return graph.adjacencyMap[placeholder]
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

}