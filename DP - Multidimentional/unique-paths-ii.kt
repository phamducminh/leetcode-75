class Solution {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val row = obstacleGrid.size
        val col = obstacleGrid[0].size

        val dp = Array(row) { IntArray(col) }

        for (i in 0 until row) {
            if (obstacleGrid[i][0] == 1) break
            dp[i][0] = 1
        }

        for (j in 0 until col) {
            if (obstacleGrid[0][j] == 1) break
            dp[0][j] = 1
        }

        for (i in 1 until row) {
            for (j in 1 until col) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]
                }
            }
        }

        return dp[row-1][col-1]
    }
}