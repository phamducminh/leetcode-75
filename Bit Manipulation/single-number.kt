class Solution {
    fun singleNumber(nums: IntArray): Int {
        var res = nums[0]
        for (i in 1 until nums.size) {
            res = res.xor(nums[i])
        }

        return res
    }
}