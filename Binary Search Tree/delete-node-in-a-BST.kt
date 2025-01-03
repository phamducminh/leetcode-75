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
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null

        if (key > root.`val`) {
            root.right = deleteNode(root.right, key)
        } else if (key < root.`val`) {
            root.left = deleteNode(root.left, key)
        } else {
            if (root.left == null) {
                return root.right
            } else if (root.right == null) {
                return root.left
            }

            // Find the min in the right subtree
            var cur = root.right
            while (cur != null && cur.left != null) {
                cur = cur.left
            }
            root.`val` = cur!!.`val`
            root.right = deleteNode(root.right, root.`val`)
        }
        return root
    }
}