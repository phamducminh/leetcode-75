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
    fun leafSequence(root: TreeNode?, list: MutableList<Int>) {
        if (root!= null && root.left == null && root.right == null) {
            list.add(root.`val`)
            return
        }

        if (root != null){
            if (root.left != null) {
                leafSequence(root.left, list)
            }

            if (root.right != null) {
                leafSequence(root.right, list)
            }
        }
    }

    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()

        leafSequence(root1, list1)
        leafSequence(root2, list2)

        return list1 == list2
    }
}