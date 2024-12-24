class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        val sLength = s.length
        var sIdx = 0

        for (char in t) {
            if (sLength > 0 && char == s[sIdx]) {
                sIdx++
            }

            if (sIdx == sLength) {
                break
            }
        }

        return sIdx == sLength
    }
}