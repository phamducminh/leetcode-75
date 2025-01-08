class Solution {

    // fun dfs(isConnected: Array<IntArray>, visited: MutableList<Boolean>, city: Int): Int {
    //     val stack = Stack<Int>()

    //     visited[city] = true
    //     stack.add(city)

    //     while (stack.isNotEmpty()) {
    //         val adjacencyCity = stack.pop()
    //         isConnected[adjacencyCity].forEachIndexed { index, connected ->
    //             if (connected == 1 && !visited[index]) {
    //                 visited[index] = true
    //                 stack.add(index)
    //             }
    //         }
    //     }

    //     for (i in 0 until visited.size) {
    //         if (!visited[i]) return i
    //     }

    //     return -1
    // }

    // fun findCircleNum(isConnected: Array<IntArray>): Int {
    //     var provinces = 0
    //     var city = 0
    //     val visited = mutableListOf<Boolean>()

    //     for (i in 0 until isConnected.size) {
    //         visited.add(false)
    //     }

    //     while(city != -1) {
    //         city = dfs(isConnected, visited, city)
    //         provinces++
    //     }

    //     return provinces
    // }
    fun dfs(isConnected: Array<IntArray>, visited: IntArray, city: Int) {
        isConnected[city].forEachIndexed { index, value -> 
            if (value == 1 && visited[index] == 0) {
                visited[index] = 1
                dfs(isConnected, visited, index)
            }
        }
    }

    fun findCircleNum(isConnected: Array<IntArray>): Int {
        var provinces = 0
        val visited = IntArray(isConnected.size)
        for (i in 0 until isConnected.size) {
            if (visited[i] == 0) {
                dfs(isConnected, visited, i)
                provinces++
            }
        }
        return provinces
    }
}