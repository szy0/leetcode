import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;

        if (len<=2) return 0;

        int sum0 = nums[0] + nums[1] + nums[len-1];
        int absGap0 = (int)Math.abs(sum0-target);
        int[] resultArr = {nums[0], nums[1], nums[len-1]};


        if (len == 3) return sum0;
        
        for (int i=0; i<=len-3; i++) {
            int left = i+1;
            int right = len-1;
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                int currentGap = (int)Math.abs(currentSum-target);
                if (currentGap < absGap0) {
                    absGap0 = currentGap;
                    sum0 = currentSum;
                }
                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    return currentSum;
                }
            }

        }
        return sum0;

    }

}