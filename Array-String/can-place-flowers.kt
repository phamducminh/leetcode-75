class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var numFlowers = 0
        val flowerbedLen = flowerbed.size

        for (i in 0 until flowerbedLen) {
            if (flowerbed[i] == 0
                && (i == 0 || flowerbed[i - 1] == 0)
                && (i == flowerbedLen - 1 || flowerbed[i + 1] == 0)
                ) {
                flowerbed[i] = 1
                numFlowers++
                }
        }
        return numFlowers >= n
    }
}