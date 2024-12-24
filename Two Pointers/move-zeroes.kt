class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var l = 0
        var r = 0

        while (r < nums.size) {
            if (nums[l] == 0 && nums[r] != 0) {
                nums[l] = nums[r]
                nums[r] = 0
                l++
                r++
            } else if (nums[l] != 0) {
                l++
                r = l
            } else {
                r++
            }
        }
    }
}