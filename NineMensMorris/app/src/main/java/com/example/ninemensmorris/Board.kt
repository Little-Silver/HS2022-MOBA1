package com.example.ninemensmorris

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

        graph.addEdgeBidirectional(p001, setOf(p000, p010, p101))
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

}