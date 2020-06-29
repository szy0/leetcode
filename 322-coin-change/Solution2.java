// from another coder
// bottom-up approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        if (amount <= 0) return 0; // required by the test case
        
        int[] dp = new int[amount + 1];
        int sum = 0; // from (0),1,2,3... to amount

        while (++sum <= amount) { // starting from 1
            int min = -1;
            for (int coin : coins) {
                if (sum >= coin && dp[sum - coin] >= 0) {
                    int tmp = dp[sum - coin] + 1;
                    if (min == -1) min = tmp;
                    else {
                        min = Math.min(tmp, min);
                    }
                }
            }
            dp[sum] = min; // update current least number of coins
        }
        return dp[amount];
    }
}