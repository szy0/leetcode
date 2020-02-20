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
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        else
            return appendList(appendList(inorderTraversal(root.left),
            Arrays.asList(root.val)), inorderTraversal(root.right));
       
    }

    public List<Integer> appendList(List<Integer> a, List<Integer> b) {
        a.addAll(b);
        return a;
    }
}