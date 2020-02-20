import java.util.*;

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length ==0)
            return 0;
        int runSum = nums[0];
        int result = runSum; 
        for(int end = 1; end < nums.length; end++) {
            runSum = runSum >= 0 ? runSum + nums[end] :  nums[end];
            result = Math.max(runSum, result);
        }
        return result;
    }
}