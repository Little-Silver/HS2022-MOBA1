package com.example.ninemensmorris

/**
 *
 */
class Board {

    val graph: Graph<Placeholder> = Graph()

    constructor() {

        var p1:Placeholder = Placeholder("000", true)
        var p2:Placeholder = Placeholder("001", false)
        var p3:Placeholder = Placeholder("002", true)
        var p4:Placeholder = Placeholder("010", false)
        var p5:Placeholder = Placeholder("020", true)
        var p6:Placeholder = Placeholder("012", false)
        var p7:Placeholder = Placeholder("021", false)
        var p8:Placeholder = Placeholder("022", true)

        var p9:Placeholder = Placeholder("100", true)
        var p10:Placeholder = Placeholder("110", false)
        var p11:Placeholder = Placeholder("120", true)
        var p12:Placeholder = Placeholder("101", false)
        var p13:Placeholder = Placeholder("102", true)
        var p14:Placeholder = Placeholder("112", false)
        var p15:Placeholder = Placeholder("122", true)
        var p16:Placeholder = Placeholder("121", false)

        var p17:Placeholder = Placeholder("200", true)
        var p18:Placeholder = Placeholder("201", false)
        var p19:Placeholder = Placeholder("202", true)
        var p20:Placeholder = Placeholder("210", false)
        var p21:Placeholder = Placeholder("220", true)
        var p22:Placeholder = Placeholder("221", false)
        var p23:Placeholder = Placeholder("222", true)
        var p24:Placeholder = Placeholder("212", false)

        graph.addEdgeBidirectional(p2, setOf(p1, p4, p12))
        graph.addEdgeBidirectional(p4, setOf(p1, p5, p10))
        graph.addEdgeBidirectional(p6, setOf(p3, p8, p14))
        graph.addEdgeBidirectional(p7, setOf(p5, p8, p16))

        graph.addEdgeBidirectional(p10, setOf(p4, p9, p11, p20))
        graph.addEdgeBidirectional(p12, setOf(p2, p9, p13, p18))
        graph.addEdgeBidirectional(p14, setOf(p6, p13, p15, p24))
        graph.addEdgeBidirectional(p16, setOf(p7, p11, p15, p22))

        graph.addEdgeBidirectional(p18, setOf(p17, p19, p12))
        graph.addEdgeBidirectional(p20, setOf(p17, p21, p10))
        graph.addEdgeBidirectional(p22, setOf(p23, p21, p16))
        graph.addEdgeBidirectional(p24, setOf(p23, p19, p14))
    }

}