class Solution {
    fun pivotIndex(nums: IntArray): Int {
        val total = nums.sum()

        var leftSum = 0
        var rightSum = 0
        for (i in 0 ..< nums.size) {
            rightSum = total - nums[i] - leftSum
            if (leftSum == rightSum) {
                return i
            }
            leftSum += nums[i]
        }
        return -1   
    }
}