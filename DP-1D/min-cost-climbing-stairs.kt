class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val n = cost.size
        val dp = IntArray(n)
        for (i in 0 until n) {
            if (i < 2) {
                dp[i] = cost[i]
            } else {
                dp[i] = cost[i] + min(dp[i-1], dp[i-2])
            }
        }
        return min(dp[n-1], dp[n-2])
    }
}