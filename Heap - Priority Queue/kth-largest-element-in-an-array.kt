class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        // val pq: PriorityQueue<Int> = PriorityQueue { o1: Int, o2: Int -> o2.compareTo(o1) }
        // nums.forEach { value -> pq.add(value) }
        // for (i in 0 until k - 1) pq.remove()
        // return pq.peek()

        // Approach 1: Use min-heap/priority queue of size k. Iterate through all the
        // values. If the size of the heap is > k, poll the min element. Finally, the
        // Kth largest would be at the root of the heap.
        // T = O(n * log k)
        val heap = PriorityQueue<Int>()
        for (i in 0 until nums.size) {
            heap.add(nums[i])
            if (heap.size > k) heap.poll()
        }

        return heap.peek()
    }
}