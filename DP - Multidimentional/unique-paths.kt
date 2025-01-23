class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = IntArray(n) { 1 }

        for (i in 1 until m) {
            for (j in n - 2 downTo 0) {
                dp[j] += dp[j + 1]
            }
        }

        return dp[0]
    }
}