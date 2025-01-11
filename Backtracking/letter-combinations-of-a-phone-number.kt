class Solution {
    fun letterCombinations(digits: String): List<String> {
        val res = mutableListOf<String>()

        val map: Map<Int, String> = mapOf(
            2 to "abc",
            3 to "def",
            4 to "ghi",
            5 to "jkl",
            6 to "mno",
            7 to "pqrs",
            8 to "tuv",
            9 to "wxyz",
        )

        fun backtrack(i: Int, curStr: String) {
            if (curStr.length == digits.length) {
                res.add(curStr)
                return
            }

            for (c in map[digits[i].toString().toInt()]!!) {
                backtrack(i + 1, curStr + c)
            }
        }

        if (digits.isNotEmpty()) {
            backtrack(0, "")
        }

        return res
    }
}