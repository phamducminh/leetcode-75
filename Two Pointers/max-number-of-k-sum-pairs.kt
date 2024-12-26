class Solution {
    fun maxOperations(nums: IntArray, k: Int): Int {
        // HashMap
        // var res = 0
        // val hashMap: MutableMap<Int, Int> = HashMap()

        // for (num in nums) {
        //     hashMap[num] = (hashMap[num] ?: 0) + 1
        // }

        // for (num in nums) {
        //     if (hashMap.containsKey(num)) {
        //         if (num.toDouble() == k / 2.0) {
        //             res += floor(hashMap[num]!! / 2.0).toInt()
        //             hashMap.remove(num)
        //         } else {
        //             if (hashMap.containsKey(k - num)) {
        //                 res += min(hashMap[num]!!, hashMap[k - num]!!)
        //                 hashMap.remove(num)
        //                 hashMap.remove(k - num)
        //             }
        //         }
        //     }
        // }

        // return res

        // Two pointers
        var operation = 0
        var l = 0
        var r = nums.size - 1
        nums.sort()
        while (l < r) {
            val sum = nums[l] + nums[r]
            when {
                sum > k -> r--
                sum < k -> l++
                else -> {
                    r--
                    l++
                    operation++
                }
            }
        }

        return operation
    }
}