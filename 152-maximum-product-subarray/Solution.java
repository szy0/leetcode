import java.util.ArrayList;
import java.util.List;
// this solution works, passed the majority of the tests, while failed at the very last test
// memory limit exceed
// I guess I should turn to 1D dp array, but I am not skilled enough

class Solution {
    // it is promised that nums have >= 1 element
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];

        int start = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (start <= i - 1) {
                    max = Math.max(max, maxSubarrayProduct(nums, start, i-1));
                    start = i + 1;
                } else {
                    start++;
                }
                    
            }
        }

        if (start <= nums.length - 1) {
            max = Math.max(max, maxSubarrayProduct(nums, start, nums.length - 1));
        }

        return max;
    }

    // start index and end index, both inclusive
    public int maxSubarrayProduct(int[] nums, int start, int end) {
        int len = end - start + 1;
        int[][] dp = new int[len + 1][len + 1];

        dp[1][0] = 1;
        int max = 0;
        for (int j = 1; j <= len; j++) {
            dp[1][j] = dp[1][j-1] * nums[j-1 + start]; // product from 1 to each element
            if (dp[1][j] > max) {
                max = dp[1][j];
            }
        }

        for (int i = 2; i <= len; i++) {
            for (int j = i; j <= len; j++) {
                dp[i][j] = dp[1][j] / dp[1][i - 1]; // always dividable
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }
}