class Solution {
    fun predictPartyVictory(senate: String): String {
       val rad = LinkedList<Int>()
        val dir = LinkedList<Int>()
        var n = senate.length

        senate.forEachIndexed { index, c -> if (c == 'R') rad.add(index) else dir.add(index) }

        while (rad.isNotEmpty() && dir.isNotEmpty()) {
            if (rad.peek() < dir.peek()) {
                rad.add(n++)
            } else {
                dir.add(n++)
            }
            rad.poll()
            dir.poll()
        }

        return if (rad.isEmpty()) "Dire" else "Radiant" 
    }
}