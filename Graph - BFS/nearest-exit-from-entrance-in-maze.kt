class Solution {
    data class Direction(val dx: Int, val dy: Int)

    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val row = maze.size
        val col = maze[0].size

        val (sx, sy) = entrance
    
        val visited = Array(row) { BooleanArray(col) }
        visited[sx][sy] = true

        val q: Queue<Pair<Int, Int>> = LinkedList()
        q.add(Pair(sx, sy))

        val directions = listOf(
            Direction(1, 0),
            Direction(0, 1),
            Direction(-1, 0),
            Direction(0, -1),
        )

        var res = 0
        while (q.isNotEmpty()) {
            val size = q.size
            repeat(size) {
                val (x, y) = q.poll()

                directions.forEach { direction -> 
                    val nx = x + direction.dx
                    val ny = y + direction.dy

                    if (nx in 0 until row
                        && ny in 0 until col
                        && maze[nx][ny] == '.'
                        && !visited[nx][ny]
                    ) {
                        visited[nx][ny] = true

                        if (nx == 0 || nx == row - 1 || ny == 0 || ny == col - 1) {
                            return res + 1
                        }

                        q.add(Pair(nx, ny))
                    }
                }
            }
            res++
        }

        return -1
    }
}