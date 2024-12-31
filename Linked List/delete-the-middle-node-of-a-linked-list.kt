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
    fun deleteMiddle(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return null
        }

        var temp = head
        var n = 0
        
        while (temp != null) {
            n++
            temp = temp.next 
        }
        
        val middle = n / 2
        var index = 0
        temp = head
        
        while (temp != null) {
            if (index + 1 == middle) {
                temp.next = temp.next?.next
                break
            } else {
                temp = temp.next
                index++
            }
        }
        
        return head
    }

    // Two pointers approach
    fun deleteMiddle(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return null
        }

        var prev: ListNode? = null
        var slow = head
        var fast = head

        while (fast?.next != null) {
            prev = slow
            slow = slow?.next
            fast = fast.next?.next
        }

        prev?.next = slow?.next

        return head
    }
}