/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun pairSum(head: ListNode?): Int {
        val map = mutableMapOf<Int, Int>()

        var n = 0
        var temp = head
        while (temp != null) {
            map[n++] = temp.`val`
            temp = temp.next
        }

        var max = 0
        for (i in 0 ..< n) {
            val sum = map[i]!! + map[n - 1 - i]!!
            max = max(max, sum)
        }
        
        return max
    }

    // Use Stack
    fun pairSum(head: ListNode?): Int {
        var slow = head
        var fast = head
        var maxSum = 0
        val stack = Stack<Int>()

        while (fast != null) {
            stack.add(slow?.`val`)
            slow = slow?.next
            fast = fast.next?.next
        }

        while (slow != null) {
            maxSum = max(maxSum, slow.`val` + stack.pop())
            slow = slow?.next
        }

        return maxSum
    }
}