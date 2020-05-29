class Solution {
    public int rob(int[] num) {
        // dp[i][0] means the money we can get if we do not robber this house
        // dp[i][1] means the money we can get if we robber this house
        int[][] dp = new int[num.length + 1][2];
        for (int i = 1; i <= num.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + num[i-1];
        }
        return Math.max(dp[num.length][0], dp[num.length][1]);
    }
}