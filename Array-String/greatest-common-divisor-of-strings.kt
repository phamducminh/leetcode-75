class Solution {
    private fun gcd(a: Int, b: Int): Int = 
        if (b == 0) a else gcd(b, a % b)

    private fun isDivisible(s: String, t: String): Boolean = 
        s == t.repeat(s.length / t.length)

    fun gcdOfStrings(str1: String, str2: String): String {
        // Find the gcd of the lengths of str1 and str2
        val gcdLength = gcd(str1.length, str2.length)

        // Candidate for the greatest common divisor of strings
        val candidate = str1.substring(0, gcdLength)

        // Check if candidate divides both strings
        return if (isDivisible(str1, candidate) && isDivisible(str2, candidate)) {
            candidate
        } else {
            ""
        }
    }
}