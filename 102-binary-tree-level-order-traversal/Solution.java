import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<TreeNode>> nodes = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        nodes.add(Arrays.asList(root));
        res.add(Arrays.asList(root.val));
        // new ArrayList<TreeNode>(root) is not valid!!

        while (true) {
            List<Integer> level = new ArrayList<>();
            List<TreeNode> nodesNextLevel = new ArrayList<>();
            int size = nodes.size();
            for (TreeNode node : nodes.get(size - 1)) {
                if (node.left != null) {
                    level.add(node.left.val);
                    nodesNextLevel.add(node.left);
                } 
                if (node.right != null) {
                    level.add(node.right.val);
                    nodesNextLevel.add(node.right);
                } 
            }
            if (nodesNextLevel.size() == 0) break;
            nodes.add(nodesNextLevel);
            res.add(level);
        }

        return res;

    }
}