// this solution does NOT work!!!!!!!
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        if (amount == 0) return 0;
        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int j = 1; j <= amount; j++) {
            dp[1][j] = (j % coins[0] == 0) ? j/coins[0] : -1;
        }

        for (int i = 2; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = j;
                int k = 1;
                while (j - coins[i-1]*k >= 0) {
                    if (dp[i][j - coins[i-1]*k] != -1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i-1]*k] + k);
                    }
                    k++;
                }
                if (dp[i-1][j] >= 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
                } else {
                    if (k == 1) {
                        dp[i][j] = -1;
                    }
                }
                
            }
        }

        printArr(dp);
        return dp[coins.length][amount] == 0 ? -1 : dp[coins.length][amount];

    }

    private void printArr(int[][] dp){
        for (int[] line : dp) {
            for (int i : line) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}