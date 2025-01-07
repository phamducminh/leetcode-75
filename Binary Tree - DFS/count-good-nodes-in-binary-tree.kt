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
    fun dfs(root: TreeNode?, max: Int = Int.MIN_VALUE): Int {
        if (root == null) return 0
        var res = if (root.`val` >= max) 1 else 0
        return res + dfs(root.left, max(root.`val`, max)) + dfs(root.right, max(root.`val`, max))
    }

    fun goodNodes(root: TreeNode?): Int {
        return dfs(root)
    }
}