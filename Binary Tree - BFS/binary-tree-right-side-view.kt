/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        if (root == null) return result
        
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        
        while (queue.isNotEmpty()) {
            val size = queue.size
            var rightmost = -1
            
            for (i in 0 until size) {
                val node = queue.poll()
                rightmost = node.`val`
                
                if (node.left != null) queue.add(node.left)
                if (node.right != null) queue.add(node.right)
            }
            
            result.add(rightmost)
        }
        
        return result
    }
}