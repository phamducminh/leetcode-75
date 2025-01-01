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
    fun helper(root: TreeNode?, maxValue: Int): Int {
        if (root == null) return 0
        if (root.`val` < maxValue) {
            return helper(root.left, maxValue) + helper(root.right, maxValue)
        } else {
            val currMax = max(maxValue, root.`val`)
            return 1 + helper(root.left, currMax) + helper(root.right, currMax)
        }
    }

    fun goodNodes(root: TreeNode?): Int { 
        var max = root?.`val` ?: Int.MIN_VALUE
        return 1 + helper(root?.left, max) + helper(root?.right, max)
    }
}