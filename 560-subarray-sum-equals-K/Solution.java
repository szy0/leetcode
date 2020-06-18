// dp is literally dynamic, its form changes according to different problems
// here dp[i][j] means the sum from ith to jth element

// this dp solution is written by myself
// works, but memory limit exceeded, indeed only half of the 2d array is useful
// so I should try to use 1d array to do the same thing

// the 2nd method also work, with a memory usage 42MB
// but it is very slow, >400ms
// actually it is "cumulative sum" solution, not very "dp"
class Solution {

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        if (nums == null || nums.length == 0) return res;

        int[] dp = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = dp[i-1] + nums[i-1];
        }

        for (int i = 0; i <= nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                if (dp[j] - dp[i] == k) res++; 
            }
        }
        return res;
    }

    // public int subarraySum(int[] nums, int k) {
    //     int res = 0;
    //     if (nums == null || nums.length == 0) return res;

    //     int[][] dp = new int[nums.length + 1][nums.length + 1];
    //     for (int j = 1; j <= nums.length; j++) {
    //         dp[1][j] = dp[1][j-1] + nums[j-1];
    //         if (dp[1][j] == k) res++;
    //     }

    //     for (int i = 2; i <= nums.length; i++) {
    //         for (int j = i; j <= nums.length; j++) {
    //             dp[i][j] = dp[1][j] - dp[1][i-1];
    //             if (dp[i][j] == k) res++;
    //         }
    //     }
    //     return res;
    // }
}