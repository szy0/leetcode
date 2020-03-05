/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // int cannot be null, but tree node can be.
        if (root == null) return true;
        if (root.left == null || root.right == null) 
            return (root.left == null && root.right == null)? true : false;
        else
            return isMirrorTree(root.left, root.right);   
    }

    // a and b will not be empty
    // but subtrees can be
    private boolean isMirrorTree(TreeNode a, TreeNode b) {
        if (a == null || b == null)
            return (a == null && b == null)? true : false;

        return (a.val != b.val)? false : (isMirrorTree(a.left, b.right) && isMirrorTree(a.right, b.left));
    }
}