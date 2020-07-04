// 1d dp array, improved from solution1
// go see author's Solution post

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int maxLen = 0;
        int prev = 0;

        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int tmp = dp[j];

                if (matrix[i-1][j-1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j-1], prev), dp[j]) + 1;
                    maxLen = Math.max(maxLen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = tmp;
            }
        }
        return maxLen * maxLen; // square area
    }
}