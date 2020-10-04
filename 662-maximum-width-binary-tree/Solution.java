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
    static class Pair {
        TreeNode node;
        int level;
        int x;
        Pair(){}
        Pair(TreeNode node, int level, int x) {
            this.node = node;
            this.level = level;
            this.x = x;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0, 0));
        List<List<Integer>> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (pair.node.left != null) {
                queue.offer(new Pair(pair.node.left, pair.level + 1, pair.x * 2));
            }
            if (pair.node.right != null) {
                queue.offer(new Pair(pair.node.right, pair.level + 1, pair.x * 2 + 1));
            }
            if (pair.level > list.size() - 1) {
                list.add(new ArrayList<Integer>());
            }
            list.get(pair.level).add(pair.x);
        }
        int res = 1;// num of nodes >= 1
        for (int i = 1; i < list.size(); i++) {
            List<Integer> tmp = list.get(i);
            res = Math.max(res, tmp.get(tmp.size() - 1) - tmp.get(0));
        }
        return res;
    }
}