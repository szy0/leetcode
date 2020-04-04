import java.util.*;

// class Solution {
//     public int maxSubArray(int[] nums) {
//         int len = nums.length;
//         int sum = nums[0];
//         int result = sum;
//         if (len == 0 || nums == null) return 0;
//         if (len == 1) return nums[0];

//         for (int k = 1; k < len; k++) {
//             sum = (sum >= 0) ? sum + nums[k] : nums[k];
//             result = Math.max(result, sum); 
//         }
//         return result;
//     }
// }



class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int localmax = nums[0]; // the max sum before the current element
        int max = nums[0];  // global max sum
        for (int i = 1; i < nums.length; i++) {
            localmax = Math.max(nums[i], nums[i] + localmax);
            max = Math.max(localmax, max);
        }
        return max;
    }
}