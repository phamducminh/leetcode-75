class Solution {
    fun increasingTriplet(nums: IntArray): Boolean {
        var firstSmallest = Int.MAX_VALUE
        var secondSmallest = Int.MAX_VALUE

        for (i in 0 .. nums.size-1) {
            val num = nums[i]
            if (num <= firstSmallest) firstSmallest = num
            else if (num <= secondSmallest) secondSmallest = num
            else return true
        }
        
        return false
    }
}