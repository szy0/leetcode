// from another coder
// for this problem, duplicates in nums is meaningless for our result
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int x : nums) {
            // only put distinct elements into dp
            int i = Arrays.binarySearch(dp, 0, len, x);
            if (i < 0) {
                i = -(i + 1);
                dp[i] = x;
                if (i == len) len++; 
            }
            // means a new element has been put into dp (at the end)
            // so the lengthOfLIS++, as all elements in dp are in sorted order
            // if a new element would been put into dp, but not at the end, instead in the somewhere mid, that will not change our result
        }
        return len;
    }
}