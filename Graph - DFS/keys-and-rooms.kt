    class Solution {
        fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
            val stack = Stack<Int>()
            val visited = mutableListOf<Boolean>()

            for (i in 0 until rooms.size) {
                visited.add(false)
            }

            visited[0] = true
            stack.add(0)

            while (stack.isNotEmpty()) {
                val room = stack.pop()
                rooms[room].forEach { key -> 
                    if (!visited[key]) {
                        visited[key] = true
                        stack.add(key)
                    }
                }
            }

            for (i in 0 until visited.size) {
                if (!visited[i]) return false
            }

            return true
        }
    }