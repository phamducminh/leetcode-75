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
    fun dfs(root: TreeNode?, isLeft: Boolean, depth: Int): Int {
        if (root == null) return depth
        if (isLeft) {
            return maxOf(
                depth,
                dfs(root.right, false, depth + 1),
                dfs(root.left, true, 0)
            )
        } else {
            return maxOf(
                depth,
                dfs(root.left, true, depth + 1),
                dfs(root.right, false, 0)
            )
        }
    }

    fun longestZigZag(root: TreeNode?): Int {
        if (root == null) return 0
        return max(dfs(root.left, true, 0), dfs(root.right, false, 0))
    }
}