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

 // similar to solution2, this solution use in-order traversal
 // two global variables are used, so that we do not need a list
class Solution {
    private int res = 0;
    private int count = 0; // need to be global, we cannot pass it to method
    // traverseInorder(root, count, k) does not work

    public int kthSmallest(TreeNode root, int k) {
        traverseInOrder(root, k);
        return res;
    }

    private void traverseInOrder(TreeNode root, int k) {
        if (root == null) return;

        traverseInOrder(root.left, k);

        count++;
        if (count == k) {
            res = root.val;
            return;
        }
        if (count > k) return; // no need to go right side, saving time
        traverseInOrder(root.right, k);
    }
}