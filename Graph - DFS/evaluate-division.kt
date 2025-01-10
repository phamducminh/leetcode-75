class Solution {
    fun bfs(
        graph: HashMap<String, ArrayList<Pair<String, Double>>>,
        src: String,
        target: String
    ): Double {
        if (!graph.containsKey(src) || !graph.containsKey(target)) {
            return -1.0
        }

        val queue: Queue<Pair<String, Double>> = LinkedList()
        val visited = hashSetOf<String>()

        queue.add(Pair(src, 1.0))
        visited.add(src)

        while (queue.isNotEmpty()) {
            val (n, accumulateWeight) = queue.poll()

            if (n == target) {
                return accumulateWeight
            }

            graph[n]!!.forEach { pair ->
                val (neighbor, weight) = pair
                if (!visited.contains(neighbor)) {
                    queue.add(Pair(neighbor, accumulateWeight * weight))
                    visited.add(neighbor)
                }
            }
        }

        return -1.0
    }

    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        // Map a -> list of [b, a/b]
        val graph = HashMap<String, ArrayList<Pair<String, Double>>>()
        equations.forEachIndexed { index, equation ->
            val (a, b) = equation
            graph.computeIfAbsent(a) { arrayListOf() }.add(Pair(b, values[index]))
            graph.computeIfAbsent(b) { arrayListOf() }.add(Pair(a, 1.0 / values[index]))
        }

        return DoubleArray(queries.size).apply {
            queries.forEachIndexed { index, query ->
                set(index, bfs(graph, query[0], query[1]))
            }
        }
    }
}