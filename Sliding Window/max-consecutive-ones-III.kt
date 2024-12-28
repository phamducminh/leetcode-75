class Solution {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var max_w = 0
        var num_zeros = 0
        val n = nums.size
        var l = 0

        for (r in 0 ..< n) {
            if (nums[r] == 0) {
                num_zeros++
            }

            while (num_zeros > k) {
                if (nums[l] == 0) {
                    num_zeros--
                }
                
                l++
            }

            val w = r - l + 1
            max_w = max(max_w, w)
        }

        return max_w
    }
}