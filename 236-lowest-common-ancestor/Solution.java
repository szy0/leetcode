import java.util.*;

// backtracking
// works but slow >500ms

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = findPath(root, p);
        List<TreeNode> path2 = findPath(root, q);
        
        // printPath(path1);
        // printPath(path2);

        for (int i = path1.size() -1; i >= 0; i--) {
            if (path2.contains(path1.get(i))) {
                return path1.get(i);
            }    
        }
        return root;
    }

    private List<TreeNode> findPath(TreeNode root, TreeNode target) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) return res;
        if (root == target) {
            res.add(target);
            return res;
        }

        res.add(root);

        List<TreeNode> t1 = findPath(root.left, target);
        List<TreeNode> t2 = findPath(root.right, target);
        if (t1.size() >= 1 && t1.get(t1.size()-1) == target)   res.addAll(t1);
        else   res.addAll(t2);

        return res;
    } 

    // private void printPath(List<TreeNode> path) {
    //     String s = "";
    //     for (TreeNode t : path) {
    //         s += t.val + " - ";
    //     }
    //     System.out.println(s.substring(0, s.length()-3));
    // }
}
