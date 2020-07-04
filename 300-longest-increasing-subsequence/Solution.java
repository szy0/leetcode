// my easy-understanding solution
// works, but slow (36ms)
class Solution {
    // this is from other coder, the same idea, O(N^2) time, but much cleaner
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }



    // public int lengthOfLIS(int[] nums) {
    //     if (nums == null || nums.length == 0) return 0;
    //     int[][] sub = new int[nums.length][2]; // storing the len of LIS
    //     sub[0][0] = 0;// max len of LIS if NOT containing current element
    //     sub[0][1] = 1; // max len of LIS if containing current element

    //     for (int i = 1; i < nums.length; i++) {
    //         sub[i][0] = Math.max(sub[i - 1][0], sub[i - 1][1]);   
    //         if (nums[i] > nums[i - 1]) {
    //             sub[i][1] = sub[i - 1][1] + 1;
    //         } else {
    //             sub[i][1] = 1; // for initializing
    //         }       
    //         for (int j = i - 2; j >= 0; j--) {
    //             if (nums[i] > nums[j]) {
    //                 sub[i][1] = Math.max(sub[i][1], sub[j][1] + 1);
    //             }
    //         } 
    //     }
    //     return Math.max(sub[nums.length - 1][0], sub[nums.length - 1][1]);
    // }
}