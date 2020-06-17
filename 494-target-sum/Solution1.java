// subset a, subset b, assume that for b, the coefficients are -1
// a + b = sum, a - b = S   -> 2 *a = sum + S 
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        for (int n : nums) sum += n;

        if (S > sum || (sum + S)%2 == 1) {
            return 0;
        } else {
            //System.out.println("test");
            return pickSubset(nums, (sum + S)/2);
        }
    }
    // turning the question into "how many ways to pick a subset from nums, making their sum equals to target?"
    private int pickSubset(int[] nums, int target) {
        int[][] dp = new int[nums.length + 1][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][target];
    }
}