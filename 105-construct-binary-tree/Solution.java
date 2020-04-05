/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // assume that no duplicates in the tree
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) return root;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                root.left = buildTree(trimArr(preorder, 1, i), trimArr(inorder, 0, i-1));
                root.right = buildTree(trimArr(preorder, i+1, preorder.length-1), 
                    trimArr(inorder, i+1, inorder.length-1));

                break;
            }
        }

        return root;
    }

    private int[] trimArr(int[] arr, int i, int k) {
        int[] res = new int[k - i + 1];
        for (int index = i; index <= k; index++) {
            res[index - i] = arr[index];
        }
        return res;
    }
}