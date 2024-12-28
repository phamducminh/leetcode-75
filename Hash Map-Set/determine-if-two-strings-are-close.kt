class Solution {
    fun closeStrings(word1: String, word2: String): Boolean {
        val map1: Map<Char, Int> = word1.asSequence().groupingBy { it }.eachCount()
        val map2: Map<Char, Int> = word2.asSequence().groupingBy { it }.eachCount()

        val set1: Set<Char> = word1.toSet()
        val set2: Set<Char> = word2.toSet()

        return map1.values.sorted() == map2.values.sorted() && set1 == set2
    }
}