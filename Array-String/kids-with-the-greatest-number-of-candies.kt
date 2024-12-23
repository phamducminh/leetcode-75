class Solution {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val max = candies.max()
        val result = mutableListOf<Boolean>()
        
        for (i in 0 until candies.size) {
            result.add(i, candies[i] + extraCandies >= max)
        }
        
        return result
    }
}