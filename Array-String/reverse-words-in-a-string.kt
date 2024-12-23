class Solution {
    fun reverseWords(s: String): String {
        val result = StringBuilder()
        val words: List<String> = s.split(' ')
        for (i in words.indices.reversed()) {
            if (words[i] != "") {
                result.append("${words[i]} ")
            }
        }
        return result.toString().trim()
    }

    fun reverseWords(s: String): String {
        // Split the string into words, filtering out empty parts caused by extra spaces
        val words = s.trim().split("\\s+".toRegex())

        // Reverse the list of words and join them with a single space
        return words.reversed().joinToString(" ")
    }
}