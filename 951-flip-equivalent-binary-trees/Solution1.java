/**
 * Definition for a binary tree n.
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

 // from other coder
// BFS using queues

class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(root1);
        q2.offer(root2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();

            if (n1 == null || n2 == null) {
                if (n1 != n2) return false;
                else continue; // both null
            } else {
                if (n1.val != n2.val) return false;

                // when both null, they equal
                if (n1.left == n2.left || 
                    (n1.left != null && n2.left != null && n1.left.val == n2.left.val)) {

                    q1.offer(n1.left); // same order between n1 and n2
                    q1.offer(n1.right);

                } else {
                    q1.offer(n1.right); // notice the different orders of offering
                    q1.offer(n1.left);
                }

                q2.offer(n2.left);
                q2.offer(n2.right);
            }
        }
        return q1.isEmpty() && q2.isEmpty();
    }
}