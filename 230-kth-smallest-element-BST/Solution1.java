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

 // an improved version of solution1, this solution use in-order traversal
 // it will not traverse the whole tree, it will stop at k.
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        traversalInOrder(root, list, k);
        return list.get(list.size() - 1);
    }

    private void traversalInOrder(TreeNode root, List<Integer> list, int k) {
        if (root == null) return;

        traversalInOrder(root.left, list, k);
        if (list.size() == k) return; // preventing add extra values once list.size() reaches k
        list.add(root.val);
        if (list.size() == k) return; // adding root values. treating left and right as "root" in the next recursion
        traversalInOrder(root.right, list, k);
    }

}