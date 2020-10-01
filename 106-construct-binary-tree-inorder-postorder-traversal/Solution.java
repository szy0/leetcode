import java.util.Arrays;

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }

        // part 1. get two new inorder arrays
        int rootIndex = 0;
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);
        int[] leftIn = new int[0];
        int[] rightIn = new int[0];
        int[] leftPos = new int[0];
        int[] rightPos = new int[0];

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        leftIn = Arrays.copyOfRange(inorder, 0, rootIndex);
        rightIn = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        //System.out.println("leftIn:" + Arrays.toString(leftIn));
        //System.out.println("rightIn:" + Arrays.toString(rightIn));


        // part 2. get two new postorder arrays
        // case1 have no left children
        if (leftIn.length == 0) {
            rightPos = Arrays.copyOfRange(postorder, 0, postorder.length - 1);
            root.left = null;
            root.right = buildTree(rightIn, rightPos);
            return root;
        }

        // case2 have no right children
        if (rightIn.length == 0) {
            leftPos = Arrays.copyOfRange(postorder, 0, postorder.length - 1);
            root.left = buildTree(leftIn, leftPos);
            root.right = null;
            return root;
        }

        // case3 have both left and right children
        // note that the num of left nodes are the same, both in inorder and postorder
        // although rootIndex is originated from inorder array, it has relation with postorder array
        leftPos = Arrays.copyOfRange(postorder, 0, rootIndex);
        rightPos = Arrays.copyOfRange(postorder, rootIndex, postorder.length - 1);

        root.left = buildTree(leftIn, leftPos);
        root.right = buildTree(rightIn, rightPos);
        return root;
    }
}