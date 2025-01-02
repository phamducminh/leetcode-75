/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) return null

        if (root == p || root == q) return root

        val l = lowestCommonAncestor(root.left, p, q)
        val r = lowestCommonAncestor(root.right, p, q)

        if (l != null && r != null) {
            return root
        } else if (l != null) {
            return l
        } else {
            return r
        }
    }
}