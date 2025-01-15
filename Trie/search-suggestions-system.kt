class Solution {
    fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
        val trie = Trie()

        Arrays.sort(products)

        for (product in products) {
            trie.insert(product)
        }

        return trie.search(searchWord)
    }
}

class TrieNode {
    val child: Array<TrieNode?> = Array(26) { null }
    val list = mutableListOf<String>()
}

class Trie {
    private val root: TrieNode = TrieNode()

    fun insert(word: String) {
        var ch: Int
        var temp = root
        for (c in word) {
            ch = c - 'a'
            if (temp.child[ch] == null) {
                val x = TrieNode()
                temp.child[ch] = x
            }
            temp = temp.child[ch]!!
            if (temp.list.size < 3) {
                temp.list += word
            }
        }
    }

    fun search(searchWord: String): List<List<String>> {
        val res = mutableListOf<List<String>>()
        var ch: Int
        var temp = root
        for (c in searchWord) {
            ch = c - 'a'
            if (temp.child[ch] == null) {
                break
            }
            temp = temp.child[ch]!!
            res.add(temp.list)
        }

        while (res.size < searchWord.length) {
            res.add(emptyList())
        }

        return res
    }
}