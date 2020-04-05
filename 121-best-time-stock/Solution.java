class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int len = prices.length;
        
        int profit = 0; // global max profit
        int maxCur = 0; // max current profit

        for (int i = 0; i < len-1; i++) {
            maxCur = Math.max(0, maxCur += prices[i + 1] - prices[i]);
            profit = Math.max(profit, maxCur);
        }
        return profit;
    
    }

    public static void main(String[] args) {
        int[] prices = {1,2,5,4,100};
        Solution s = new Solution();
        int output = s.maxProfit(prices);
        System.out.println(output);
    }
}