class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack: Stack<Int> = Stack()
        for (asteroid in asteroids) {
            var destroyed = false

            while (stack.isNotEmpty() && asteroid < 0 && stack.peek() > 0) {
                val topAsteroid = stack.peek()
                when {
                    topAsteroid + asteroid == 0 -> {
                        stack.pop()
                        destroyed = true
                        break
                    }
                    topAsteroid + asteroid < 0 -> {
                        stack.pop()
                    }
                    else -> {
                        destroyed = true
                        break
                    }
                }
            }

            if (!destroyed) {
                stack.push(asteroid)
            }
        }

        return stack.toIntArray()
    }
}