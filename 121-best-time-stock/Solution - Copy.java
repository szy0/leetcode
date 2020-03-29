class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int len = prices.length;
        int dayGap = len - 1;

        int sell, buy;
        int profit = 0;

        while (dayGap >= 1) {
            System.out.println("current day gap: " + dayGap);
            for (int i = 0; i + dayGap < len; i++) {
                sell = prices[i];
                buy = prices[i + dayGap];
                if (buy - sell > profit) {profit = buy - sell;}
            }
            dayGap --;
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