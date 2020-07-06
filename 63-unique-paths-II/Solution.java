class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) 
            return 0;
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
  
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i - 1][j - 1] == 1) continue;
                else {
                    if (i >= 2 && obstacleGrid[i - 2][j - 1] == 0) dp[i][j] += dp[i - 1][j];
                    if (j >= 2 && obstacleGrid[i - 1][j - 2] == 0) dp[i][j] += dp[i][j - 1];
                }
                
            }
        }
        return obstacleGrid[m - 1][n - 1] == 1 ? 0 : dp[m][n]; // for a special test case [[1]]
    }
}