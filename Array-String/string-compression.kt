class Solution {
    fun compress(chars: CharArray): Int {
        var l = 0
        var r = 1
        val n = chars.size

        var curChar = chars[0]
        var count = 1

        while (r < n) {
            if (chars[r] == curChar) {
                r++
                count++
            } else {
                l++
                if (count > 1) {
                    val digits = count.toString().toList()
                    digits.forEach { digit -> chars[l++] = digit }
                }

                curChar = chars[r]
                chars[l] = curChar
                count = 1
                r++
            }
        }

        l++
        if (count > 1) {
            val digits = count.toString().toList()
            digits.forEach { digit -> chars[l++] = digit }
        }

        return l
    }

    fun compress2(chars: CharArray): Int {
        var l = 0
        var r = 0
        val n = chars.size

        while (r < n) {
            val curChar = chars[r]
            var count = 0
            while (r < n && chars[r] == curChar) {
                r++
                count++
            }
            chars[l++] = curChar
            if (count > 1) {
                count.toString().toList().forEach { digit -> chars[l++] = digit}
            }
        }

        return l
    }
}