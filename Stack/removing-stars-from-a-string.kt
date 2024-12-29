class Solution {
    fun removeStars(s: String): String {
        val stack: Stack<Char> = Stack()
        for (c in s) {
            if (c.isLetter()) {
                stack.push(c)
            } else if (c == '*') {
                stack.pop()
            }
        }

        val result = StringBuilder()

        while (stack.isNotEmpty()) {
            result.append(stack.pop())
        }

        return result.reversed().toString()
    }
}