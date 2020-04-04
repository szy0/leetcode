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
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left; 
        if (temp != null) {
            while (temp.right != null) {
               temp = temp.right;
            }
            //flatten(root.right); // this action is not needed?
            temp.right = root.right;
            flatten(root.left);
            root.right = root.left; // pass by reference
            root.left = null; // re-assign root.left to null
        } else {
            flatten(root.right);
        }
      
        return;
    }
}
