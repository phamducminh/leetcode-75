class Solution {
    fun equalPairs(grid: Array<IntArray>): Int {
        var count = 0

        for (i in grid.indices) {
            val column = IntArray(grid.size)
            for (j in grid.indices) {
                column[j] = grid[j][i]
            }

            for (row in grid) {
                if (column contentEquals row) {
                    count++
                }
            }
        }

        return count
    }
}