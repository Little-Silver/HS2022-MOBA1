package com.example.ninemensmorris

class Graph<T> {

    val adjacencyMap: HashMap<T, HashSet<T>> = HashMap()
    val elements: MutableSet<T> = mutableSetOf()

    fun addEdge(sourceVertex: T, destinationVertex: T) {

        elements.add(sourceVertex)
        elements.add(destinationVertex)

        // Add edge to source vertex / node.
        adjacencyMap
            .computeIfAbsent(sourceVertex) { HashSet() }
            .add(destinationVertex)
        // Add edge to destination vertex / node.
        adjacencyMap
            .computeIfAbsent(destinationVertex) { HashSet() }
            .add(sourceVertex)
    }

    fun addEdgeBidirectional(vertex1: T, vSet: Set<T>) {
        for (v in vSet) {
            addEdge(vertex1, v)
            addEdge(v, vertex1)
        }
    }

    override fun toString(): String = StringBuffer().apply {
        for (key in adjacencyMap.keys) {
            append("$key -> ")
            append(adjacencyMap[key]?.joinToString(", ", "[", "]\n"))
        }
    }.toString()
}