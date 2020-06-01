class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
        

    }
}