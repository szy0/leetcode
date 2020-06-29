// from another coder
// top-down approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        if (amount <= 0) return 0; // required by the test case
        return helper(coins, new int[amount + 1], amount);
    }

    // rem: remaining amount after last step
    // count[amount]: min number of coins sum up to this amount
    private int helper(int[] coins, int[] count, int rem) {
        if (rem < 0) return -1; // impossible 
        if (rem == 0) return 0; // complete
        if (count[rem] != 0) return count[rem];

        int min = Integer.MAX_VALUE; // initialize
        for (int coin : coins) {
            int res = helper(coins, count, rem - coin);
            if (res >= 0 && res < min) {
                min = 1 + res; // 1 means current coin
            }
        }
        count[rem] = (min == Integer.MAX_VALUE) ? -1 : min; // whether possible
        return count[rem];
    }
}