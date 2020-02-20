import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    Solution(){}
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> finalResult = new ArrayList<>();

        int len = nums.length;
        Arrays.sort(nums);

        if (len <=2) return finalResult;

        for (int i=0; i<len-1; i++) {
            int left = i+1;
            int right = len-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) left++;
                if (sum > 0) right--;
                if (sum == 0) {
                    finalResult.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left<right && nums[left]==nums[left-1]) left++;
                    while (left<right && nums[right]==nums[right+1]) right--;
                }
            }

            while (i<len-1 && nums[i]==nums[i+1]){
                i++;
            }
        }
        return finalResult;
    }
} 