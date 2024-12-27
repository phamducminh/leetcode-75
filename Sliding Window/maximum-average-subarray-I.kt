class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        val n = nums.size
        if (n < k) {
            return 0.0
        }

        var total = 0.0
        for (i in 0 ..< k) {
            total += nums[i]
        }
        var maxTotal = total

        for (i in 0 ..< n - k) {
            total -= nums[i]
            total += nums[i + k]
            maxTotal = max(maxTotal, total)
        }

        return maxTotal / k
    }
}