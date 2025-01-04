class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val pq: PriorityQueue<Int> = PriorityQueue { o1: Int, o2: Int -> o2.compareTo(o1) }
        nums.forEach { value -> pq.add(value) }
        for (i in 0 until k - 1) pq.remove()
        return pq.peek()
    }
}