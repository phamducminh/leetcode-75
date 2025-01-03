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
    fun maxLevelSum(root: TreeNode?): Int {
        if (root == null) return 0

        var max = Int.MIN_VALUE
        var level = 0
        var curLevel = 0
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val size = queue.size
            var sum = 0

            curLevel += 1

            for (i in 0 until size) {
                val node = queue.poll()
                sum += node.`val`

                if (node.left != null) queue.add(node.left)
                if (node.right != null) queue.add(node.right)
            }

            
            if (sum > max) {
                max = sum
                level = curLevel
            }
        }

        return level
    }
}