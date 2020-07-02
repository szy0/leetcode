/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// this solution works, but failed at the last test: Time Limit Exceeded
// maybe I should turn it into iterative version

class Solution {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        return Math.max(helper(root, true), helper(root, false));
        // assume prev is robbed, then root cannot be robbed
        // or prev is not robbed, then we may rob the root
    }

    private int helper(TreeNode root, boolean prevRobbed) {
        if (root == null) return 0;
        int a = helper(root.left, true) + helper(root.right, true) + root.val;
        int b = helper(root.left, false) + helper(root.right, false);
        if (!prevRobbed) {
            return Math.max(a, b);
        } else {
            return b;
        }
    }
}