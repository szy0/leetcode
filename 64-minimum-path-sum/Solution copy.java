import java.util.*;
// v1
// works, but too slow, sigh
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;

        List<Integer> allPathLen = new ArrayList<>();
        backtrack(grid, new int[]{0,0}, 0, allPathLen);

        int minLen = allPathLen.get(0);
        for (int k : allPathLen) {
            if (k < minLen) {
                minLen = k;
            }
        }
        return minLen;
    }
    
    // pathLen is temp len, adding step by step, util the path become complete
    // allpathlen stores all len of all possible paths
    private void backtrack(int[][] grid, int[] pos, int pathLen, List<Integer> allPathLen) {
        pathLen += grid[pos[0]][pos[1]];
        if (pos[0] == grid.length - 1 && pos[1] == grid[0].length-1) {
            allPathLen.add(pathLen);
            return;
        }
        
        if (pos[0] + 1 <= grid.length - 1) { // go down
            backtrack(grid, new int[]{pos[0]+1, pos[1]}, pathLen, allPathLen);
        }

        if (pos[1] + 1 <= grid[0].length - 1) { // go right
            backtrack(grid, new int[]{pos[0], pos[1]+1}, pathLen, allPathLen);
        }
    }
}