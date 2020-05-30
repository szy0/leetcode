import java.util.ArrayList;
import java.util.List;
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
    // my first solution is not typically "backtrack", because it does not have "backward" actions like temp.remove()
    // it is just recursion

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        findPath(root, sum, new ArrayList<Integer>(), res);    
        return res;
    }

    // a slightly improved version. This is backtracking.
    private void findPath(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                temp.add(root.val);
                res.add(new ArrayList(temp));
                temp.remove(temp.size() - 1); // different from the first version
                return;
            } else return;
        }
        temp.add(root.val);
        findPath(root.right, sum - root.val, temp, res);  // no need to create new Arraylist, thus faster
        findPath(root.left, sum - root.val, temp, res);
        temp.remove(temp.size() - 1);  // different from the first version
        
    }

    // private void findPath(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> res) {
    //     if (root == null) return;
    //     if (root.left == null && root.right == null) {
    //         if (root.val == sum) {
    //             temp.add(root.val);
    //             res.add(temp);
    //             return;
    //         } else return;
    //     }
    //     temp.add(root.val);
    //     findPath(root.right, sum - root.val, new ArrayList<Integer>(temp), res);
    //     findPath(root.left, sum - root.val, new ArrayList<Integer>(temp), res);
        
    // }
}