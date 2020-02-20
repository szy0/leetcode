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
    public boolean isValidBST(TreeNode root) {
        return isSearchTree(root);
	}
	
	static boolean isSearchTree(TreeNode a) { // elegant solution? this one is not pretty.
		if (a == null) return true;
		if (a.left == null && a.right == null) {
			return true;
		} else {
			// needing to check both left and right parts of each subtree.
			if (a.left != null) {
				if (a.left.val >= a.val) // once violating, the whole tree is not BST.
					return false;
				else {
					TreeNode t = a.left;
					while (t.right != null) t = t.right;
					if (t.val >= a.val) return false;
				}
				
				
			}


			if (a.right != null) {
				if (a.right.val <= a.val) // once violating, the whole tree is not BST.
					return false;
				else {
					TreeNode t = a.right;
					while (t.left != null) t = t.left;
					if (t.val <= a.val) return false;
				}
			}

			return isSearchTree(a.left) && isSearchTree(a.right);
		}

	}
}

	