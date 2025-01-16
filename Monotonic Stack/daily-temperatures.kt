class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val answer = IntArray(temperatures.size) { 0 }
        val stack = Stack<Pair<Int, Int>>() // pair: [temp, index]
        
        temperatures.forEachIndexed { index, temp -> 
            while (stack.isNotEmpty() && temp > stack.peek().first) {
                val (stackTemp, stackIndex) = stack.pop()
                answer[stackIndex] = index - stackIndex
            }
            stack.push(Pair(temp, index))
        }

        return answer
    }
}