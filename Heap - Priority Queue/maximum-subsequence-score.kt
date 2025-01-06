class Solution {
    fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
        val zipped = nums1.zip(nums2).sortedByDescending { (_, min) -> min }
        val pq = PriorityQueue<Int>()
        var sum = 0L
        var res = 0L

        zipped.forEach { (num1, min) ->
            pq.add(num1)
            sum += num1
            if (pq.size > k) sum -= pq.poll()
            if (pq.size == k) res = max(res, sum * min)
        }
        
        return res
    }
}