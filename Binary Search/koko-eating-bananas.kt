class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1
        var right = piles.max()

        while (left < right) {
            val mid = (left + right) / 2

            if (canEat(piles, mid, h)) {
                right = mid
            } else {
                left = mid + 1
            }
        }

        return left
    }

    private fun canEat(piles: IntArray, speed: Int, h: Int): Boolean {
        var hours = 0

        for (pile in piles) {
            if (speed >= pile) {
                hours++
            } else {
                hours += ceil(pile / speed.toDouble()).toInt()
            }
        }

        return hours <= h
    }
}