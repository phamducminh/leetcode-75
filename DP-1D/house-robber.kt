class Solution {
    fun rob(nums: IntArray): Int {
        val robArr = IntArray(2) { 0 }
        // [rob1, rob2, n, n+1, ...]
        for (n in nums) {
            val temp = max(n + robArr[0], robArr[1])
            robArr[0] = robArr[1]
            robArr[1] = temp
        }

        return robArr[1]
    }
}