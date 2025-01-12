class Trie() {
    private val root = Node()

    fun insert(word: String) {
        var ch: Int
        var temp = root
        for (c in word) {
            ch = c - 'a'
            if (temp.child[ch] == null) {
                val x = Node()
                temp.child[ch] = x
            }
            temp = temp.child[ch]!!
        }
        temp.countWord++
    }

    fun search(word: String): Boolean {
        var ch: Int
        var temp = root
        for (c in word) {
            ch = c - 'a'
            if (temp.child[ch] == null) {
                return false
            }
            temp = temp.child[ch]!!
        }
        return temp.countWord > 0
    }

    fun startsWith(prefix: String): Boolean {
        var ch: Int
        var temp = root
        for (c in prefix) {
            ch = c - 'a'
            if (temp.child[ch] == null) {
                return false
            }
            temp = temp.child[ch]!!
        }
        return true
    }

    companion object {
        const val MAX = 26
    }
}

class Node {
    val child: Array<Node?> = Array(MAX) { null }
    var countWord: Int = 0

    companion object {
        const val MAX = 26
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */