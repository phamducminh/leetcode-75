class Solution {
    fun isVowel(c: Char): Boolean =
        c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'

    fun maxVowels(s: String, k: Int): Int {
        var total = 0
        var maxVowel = 0
        val n = s.length

        for (i in 0 ..< k) {
            if (isVowel(s[i])) {
                total++
            }
        }    

        maxVowel = total

        for (i in 0 ..< n - k) {
            if (isVowel(s[i])) total--
            if (isVowel(s[i+k])) total++
            maxVowel = max(maxVowel, total)
        }

        return maxVowel
    }
}