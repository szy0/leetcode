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

// inspired by other coder
// DFS, bottom-up solution
// father node is dependent on child nodes
class Solution {
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]); // robbing this house or not
    }

    private int[] helper(TreeNode root) {
        if (root == null) return new int[2];
        int[] a = helper(root.left); 
        int[] b = helper(root.right); // child states
         
        // 0 means not rob current node, 1 means robbing current node
        // if not robbing current house, we may rob left/right
        // if robbing current house, we must not rob left and right node
        int[] cur = new int[2];
        cur[0] = Math.max(a[0], a[1]) + Math.max(b[0], b[1]);
        cur[1] = a[0] + b[0] + root.val; 
        return cur;
    }
}