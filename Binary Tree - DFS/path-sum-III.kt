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
    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        if (root == null) return 0
        return pathSumDFS(root, targetSum.toLong()) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum)
    }

    fun pathSumDFS(root: TreeNode?, targetSum: Long): Int {
        if (root == null) return 0

        val match = if (targetSum == root.`val`.toLong()) 1 else 0
        return match + pathSumDFS(root.left, targetSum - root.`val`) + pathSumDFS(root.right, targetSum - root.`val`)
    }
}