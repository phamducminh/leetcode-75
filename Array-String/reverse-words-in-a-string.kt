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
}