/** 
 * The API guess is defined in the parent class.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num:Int):Int {}
 */

class Solution:GuessGame() {
    override fun guessNumber(n:Int):Int {
        return binarySearch(1, n)
    }

    private fun binarySearch(from: Int, to: Int): Int {
        if (from == to) return from
        val mid = ((from.toLong() + to.toLong()) / 2L).toInt()
        return when (guess(mid)) {
            -1 -> binarySearch(from, mid - 1)
            1 -> binarySearch(mid + 1, to)
            else -> mid
        }
    }
}