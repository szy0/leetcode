import java.util.ArrayList;
import java.util.List;

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
    public int pathSum(TreeNode root, int sum) {
        // loop the whole tree
        int res = 0;
        List<TreeNode> nodes = new ArrayList<>();
        traversal(root, nodes);

        for (TreeNode n : nodes) {
            res += findPath(n, sum);
        }
        return res;
    }

    // finding all possible paths starting from the root
    // no need to finish at leaf nodes
    private int findPath(TreeNode root, int sum) {
        if (root == null) return 0;
        int val = findPath(root.left, sum-root.val) + findPath(root.right, sum-root.val);
        if (root.val == sum) {
            return 1 + val;
        } else {
            return val;
        }
        
    }

    // pre-order
    private void traversal(TreeNode root, List<TreeNode> nodes) {
        nodes.add(root);
        if (root != null) {
            traversal(root.left, nodes);
            traversal(root.right, nodes);
        }
    }
}