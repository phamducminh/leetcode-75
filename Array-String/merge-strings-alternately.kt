// https://leetcode.com/problems/merge-strings-alternately
class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        var result = ""
        val n = max(word1.length, word2.length)

        for (i in 0 until n) {
            if (i < word1.length) {
                result += word1[i]
            }
            if (i < word2.length) {
                result += word2[i]
            }
        }

        return result
    }
}