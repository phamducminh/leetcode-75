class Solution {
    fun tribonacci(n: Int): Int {
        if (n == 0) return 0
        if (n == 1 || n == 2) return 1

        val array = IntArray(38)
        array[0] = 0
        array[1] = 1
        array[2] = 1

        for (i in 3 until 38) {
            array[i] = array[i - 1] + array[i - 2] + array[i - 3]
        }

        return array[n]
    }

    // Dynamic Programming
    fun tribonacci(n: Int): Int {
        val dp = intArrayOf(0, 1, 1)
        for (i in 3 .. n) {
            dp[i % 3] = dp[0] + dp[1] + dp[2]
        }
        return dp[n % 3]
    }
}