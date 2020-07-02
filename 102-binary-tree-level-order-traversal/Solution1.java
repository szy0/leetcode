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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }
    private void helper(TreeNode root, List<List<Integer>> res, int depth) {
        if (root == null) return;
        if (res.size() < depth + 1) { // when entering a new level
            res.add(new ArrayList<Integer>());
        }
        res.get(depth).add(root.val);

        helper(root.left,  res, depth + 1);
        helper(root.right, res, depth + 1); // next level
    }
}