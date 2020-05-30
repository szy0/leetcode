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
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.right == null && root.left == null) {
            return root.val == sum ? true : false;
        }
        boolean b1 = hasPathSum(root.left, sum - root.val);
        boolean b2 = hasPathSum(root.right, sum - root.val);
        
        return  b1 || b2;
    }
}