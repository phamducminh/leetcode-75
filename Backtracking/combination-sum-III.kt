class Solution {
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        if (k > n) return emptyList()

        val res = mutableListOf<List<Int>>()

        fun backtracking(i: Int, sum: Int, array: List<Int>) {
            // base case
            if (sum == n) {
                if (array.size == k) {
                    res.add(array)
                    return
                }
            }

            // recursion
            for (j in i .. 9) {
                if (sum + j > n) break
                backtracking(j + 1, sum + j, array + j)
            }
        }

        backtracking(1, 0, emptyList())

        return res
    }
}