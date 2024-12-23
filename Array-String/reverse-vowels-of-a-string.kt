class Solution {
    fun reverseVowels(s: String): String {
        val hashSet = setOf('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U')
        val result = StringBuilder(s)
        var l = 0
        var r = s.length - 1

        while (l < r) {
            if (hashSet.contains(s[l]) && hashSet.contains(s[r])) {
                result[l] = s[r]
                result[r] = s[l]
                l++
                r--
            } else if (!hashSet.contains(s[l])) {
                l++
            } else if (!hashSet.contains(s[r])) {
                r--
            }
        }

        return result.toString()
    }
}