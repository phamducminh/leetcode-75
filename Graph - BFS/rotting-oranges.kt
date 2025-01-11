class Solution {
    data class Direction(val dx: Int, val dy: Int)

    fun orangesRotting(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        var freshOranges = 0
        val q: Queue<Pair<Int, Int>> = LinkedList()

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 2) {
                    q.add(Pair(i, j))
                } else if (grid[i][j] == 1) {
                    freshOranges++
                }
            }
        }

        var time = 0

        val directions = listOf(
            Direction(dx = 1, dy = 0),
            Direction(dx = 0, dy = 1),
            Direction(dx = -1, dy = 0),
            Direction(dx = 0, dy = -1),
        )

        while (q.isNotEmpty() && freshOranges > 0) {
            val size = q.size
            repeat(size) {
                val (x, y) = q.poll()

                directions.forEach { direction ->
                    val nx = x + direction.dx
                    val ny = y + direction.dy

                    if (nx in 0 until m 
                        && ny in 0 until n 
                        && (grid[nx][ny] == 1)
                    ) {
                        freshOranges--
                        grid[nx][ny] = 2
                        q.add(Pair(nx, ny))
                    }
                }
            }
            time++
        }

        return if (freshOranges == 0) time else -1
    }
}