class Solution {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val set1: Set<Int> = nums1.toSet()
        val set2: Set<Int> = nums2.toSet()

        val result: List<List<Int>> = listOf(
            (set1 subtract set2).toList(),
            (set2 subtract set1).toList()
        )

        return result
    }
}