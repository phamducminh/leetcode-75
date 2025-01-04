class Solution {
    fun binarySearch(array: IntArray, value: Int, success: Long): Int {
        var l = 0
        var r = array.size - 1

        while (l <= r) {
            val mid = l + (r - l) / 2
            if (array[mid] * value.toLong() < success) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }

        return l
    }

    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        val result = IntArray(spells.size)
        val m = potions.size

        potions.sort()

        spells.forEachIndexed { index, value ->
            result[index] = m - binarySearch(potions, value, success)
        }

        return result
    }
}