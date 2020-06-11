/**
 * Definition for a binary tree target.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// in this question, the tree is a BST
// also we can see that this tree must have >=2 nodes.

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}



















// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         List<TreeNode> path1 = new ArrayList<>();
//         List<TreeNode> path2 = new ArrayList<>();
//         findPath(root, p, path1);
//         findPath(root, q, path2);
//         for (int i = path1.size()-1; i >= 0; i--) {
//             if (path2.contains(path1.get(i))) return path1.get(i);
//         }
//         return root;
//     }

//     private void findPath(TreeNode root, TreeNode target, List<TreeNode> tmp) {
//         tmp.add(root);
//         if (root == target) return;

//         if (root.val < target.val) {
//             findPath(root.right, target, tmp);
//         } else {
//             findPath(root.left, target, tmp);
//         }
        
//     }
// }