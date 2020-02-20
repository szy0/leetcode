/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return makeTrees(1, n);
    }

    private List<TreeNode> makeTrees(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if (left > right) {
            res.add(null);
        }
        for (int index = left; index <= right; index++) {
            List<TreeNode> leftTrees = makeTrees(left, index-1);
            List<TreeNode> rightTrees = makeTrees(index+1, right);
            for (TreeNode lt : leftTrees) {
                for (TreeNode rt : rightTrees) {
                    TreeNode root = new TreeNode(index);
                    root.left = lt;
                    root.right = rt;
                    res.add(root);
                }
            }
        }
        return res;
       
    }
}