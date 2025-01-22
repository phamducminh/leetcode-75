class Solution {
    fun makeState(t1: Boolean, t2: Boolean): Int {
        if (!t1 && !t2) return 0
        if (t1 && !t2) return 1
        if (!t1 && t2) return 2
        return 3
    }

    fun numTilings(n: Int): Int {
        val MOD = 1000000007
        val dp = Array(n + 1) { Array<Int?>(4) { null } }

        fun f(i: Int, t1: Boolean, t2: Boolean): Int {
            if (i == n) return 1
            val state = makeState(t1, t2)

            if (dp[i][state] != null) {
                return dp[i][state]!!
            }

            val t3 = i + 1 < n
            val t4 = i + 1 < n
            var count = 0

            if (t1 && t2 && t3) count = (count + f(i + 1, t1 = false, t2 = true)) % MOD
            if (t1 && t2 && t4) count = (count + f(i + 1, t1 = true, t2 = false)) % MOD
            if (t1 && !t2 && t3 && t4) count = (count + f(i + 1, t1 = false, t2 = false)) % MOD
            if (!t1 && t2 && t3 && t4) count = (count + f(i + 1, t1 = false, t2 = false)) % MOD
            if (t1 && t2) count = (count + f(i + 1, true, t2 = true)) % MOD
            if (t1 && t2 && t3 && t4) count = (count + f(i + 1, t1 = false, t2 = false)) % MOD
            if (t1 && !t2 && t3) count = (count + f(i + 1, t1 = false, t2 = true)) % MOD
            if (!t1 && t2 && t4) count = (count + f(i + 1, t1 = true, t2 = false)) % MOD
            if (!t1 && !t2) count = (count + f(i + 1, t1 = true, t2 = true)) % MOD

            dp[i][state] = count
            return dp[i][state]!!
        }

        return f(0, t1 = true, t2 = true)
    }
}