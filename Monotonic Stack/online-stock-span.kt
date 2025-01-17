class StockSpanner() {
    val stack = Stack<Pair<Int, Int>>() // pair: (price, span)

    fun next(price: Int): Int {
        var span = 1
        while (stack.isNotEmpty() && price >= stack.peek().first) {
            span += stack.pop().second
        }

        stack.push(Pair(price, span))
        return span
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * var obj = StockSpanner()
 * var param_1 = obj.next(price)
 */