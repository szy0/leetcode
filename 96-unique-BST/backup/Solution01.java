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
    public int numTrees(int n) {
        if (n <= 1) return n;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        List<TreeNode> res = new ArrayList<>();
        int[] used = new int[n];

 
     
    }

    private List<TreeNode> premuateTree(int m) {
        List<TreeNode> res = new ArrayList<>();
        if (m == 1) {
            TreeNode a = new TreeNode(1);
            res.add(a);
            return res;
        }
        if (m == 2) {
            TreeNode a = new TreeNode(1);
            TreeNode b = new TreeNode(2);
            a.right = b;
            TreeNode temp = a;
            res.add(temp);

            a.right = null;
            b.left = a;
            res.add(b);
            return res;
        }

        for (TreeNode t : premuateTree(m - 1)) {
            res.add(t);
        }

        for (int l = 0;  l <= m-1; l++) {
            int r = m - 1 - l;
            premuateTree(l) * premuateTree(r);
            
        }
    }



    private int numsOfTreeNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return 1 + numsOfTreeNodes(root.left) + numsOfTreeNodes(root.right);
    }
}