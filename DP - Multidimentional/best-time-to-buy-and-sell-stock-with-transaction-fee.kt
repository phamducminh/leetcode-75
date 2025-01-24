class Solution {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        if (prices.isEmpty()) return 0

        var hold = Int.MIN_VALUE
        var sold = 0

        for (price in prices) {
            hold = maxOf(hold, sold - price)
            sold = maxOf(sold, hold + price - fee)
        }

        return sold
    }
}