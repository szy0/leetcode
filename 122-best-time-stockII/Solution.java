class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int len = prices.length;
        int globalProfit = 0;

        for (int i = 0; i < len-1; i++) {
            if (prices[i + 1] - prices[i] > 0) {
                globalProfit += prices[i + 1] - prices[i];
            }
        }
        return globalProfit;
    }
}