class Solution {
    fun countBits(n: Int): IntArray {
        val ans = IntArray(n + 1)
        
        for (i in 0 .. n) {
            if (i % 2 == 0) {
                ans[i] = ans[i / 2]
            } else {
                ans[i] = ans[i / 2] + 1
            }
        }

        return ans
    }

    fun countBits(n: Int): IntArray {
        val ans = IntArray(n + 1)
        
        for (i in 0 .. n) {
            ans[i] = ans[i.shr(1)] + (i.and(1))
        }

        return ans
    }
}