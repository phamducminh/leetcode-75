class Solution {
    fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
        var i = 0
        var j = costs.size - 1

        val pq1 = PriorityQueue<Int>()
        val pq2 = PriorityQueue<Int>()

        var res = 0L
        for (idx in 0 until k) {
            while (pq1.size < candidates && i <= j) {
                pq1.add(costs[i++])
            }
            while (pq2.size < candidates && i <= j) {
                pq2.add(costs[j--])
            }

            val t1 = if (pq1.size > 0) pq1.peek() else Int.MAX_VALUE
            val t2 = if (pq2.size > 0) pq2.peek() else Int.MAX_VALUE

            if (t1 <= t2) {
                res += t1
                pq1.poll()
            } else {
                res += t2
                pq2.poll()
            }
        }

        return res
    }
}