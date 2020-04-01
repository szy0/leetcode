// v3 DP solution.
// inspired by other coders
class Solution {
    public int minPathSum(int[][] grid) {
        int width = grid.length;
        int length = grid[0].length;
        
        for (int i = 0; i < width; i++) {
            for (int k = 0; k < length; k++) {
                if (i == 0 && k == 0) grid[i][k] = grid[i][k]; 
                // remain unchanged for the start cell

                else if (i == 0 && k != 0) grid[i][k] += grid[i][k-1]; 
                // can only go right to reach this cell

                else if (i != 0 && k == 0) grid[i][k] += grid[i-1][k]; 
                // can only go down to reach this cell

                else grid[i][k] += Math.min(grid[i-1][k], grid[i][k-1]); 
                // min of two possible paths

            }
        }
        return grid[width-1][length-1];
    }
}