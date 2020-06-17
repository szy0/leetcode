// when your recursion/backtracking solution get Time Limit Exceeded
// you know you must turn to DP

// very similar to the problem 494-target sum
// 
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length <= 1) return false;
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 == 1) return false;
        else {
            return pickSubsets(nums, sum/2);
        }
    }

    // turning this problem into "can we pick up some subsets from the arr,
    // making their sum == (total sum)/2 ?"
    // returning the amount of choices of subsets
    private boolean pickSubsets(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        // for (int j = 1; j <= target; j++) {
        //     dp[0][j] = false;
        // }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = (dp[i][j] || dp[i-1][j- nums[i-1]]);
                }
            }
        }
        return dp[nums.length][target];

 
    }
}