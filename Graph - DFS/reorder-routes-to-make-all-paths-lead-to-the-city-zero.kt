class Solution {
    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        val graph = HashMap<Int, ArrayList<Int>>()
        for ((a, b) in connections) {
            graph.computeIfAbsent(a) { arrayListOf<Int>() }.add(b)
            graph.computeIfAbsent(b) { arrayListOf<Int>() }.add(-a)
        }

        val visited = hashSetOf<Int>()
        visited.add(0)

        val queue: Queue<Int> = LinkedList()
        queue.add(0)

        var ans = 0

        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val curNode = queue.poll()

                for (dst in graph[curNode]!!) {
                    val neighbor = abs(dst)
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor)
                        queue.add(neighbor)
                        if (dst > 0) ans++
                    }
                }
            }            
        }

        return ans
    }
}