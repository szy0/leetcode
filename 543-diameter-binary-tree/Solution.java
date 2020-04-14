/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// works + a little bit slow
// I found other coders had the same idea with me in general
// I will submit another solution in Python
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        return Math.max(
            Math.max(maxHeightOfTree(root.left) + maxHeightOfTree(root.right), 
                    diameterOfBinaryTree(root.left)),
        diameterOfBinaryTree(root.right));
    }

    private int maxHeightOfTree(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.max(maxHeightOfTree(root.left), maxHeightOfTree(root.right)) + 1;
    }
}