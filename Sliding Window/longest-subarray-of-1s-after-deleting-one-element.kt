class Solution {
    fun longestSubarray(nums: IntArray): Int {
        var max_w = 0
        var max_zeros = 0
        var n = nums.size
        var l = 0

        for (r in 0 ..< n) {
            if (nums[r] == 0) {
                max_zeros++
            }

            while (max_zeros > 1) {
                if (nums[l] == 0) {
                    max_zeros--
                }

                l++
            }

            val w = r - l + 1
            max_w = max(max_w, w)
        }

        return max_w - 1
    }
}