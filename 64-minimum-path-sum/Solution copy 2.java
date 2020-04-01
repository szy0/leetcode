import java.util.*;
// v2
// a little modification on v1
// faster, but still not fast enough, taking 1800ms to pass a certain leetcode testcase
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;

        int minLen = backtrack(grid, new int[]{0,0}, 0, Integer.MAX_VALUE);
        return minLen;
    }
 
    private int backtrack(int[][] grid, int[] pos, int temp, int minLen) {
        if (pos[0] > grid.length -1  || pos[1] > grid[0].length -1 ) {
            return minLen;
        }

        temp += grid[pos[0]][pos[1]];
        if (pos[0] == grid.length - 1 && pos[1] == grid[0].length-1) {
            if (temp < minLen) minLen = temp;
            return minLen;
        }
        
        return Math.min(
            backtrack(grid, new int[]{pos[0]+1, pos[1]}, temp, minLen),
            backtrack(grid, new int[]{pos[0], pos[1]+1}, temp, minLen)
            );
   
    }
}