// from another coder
class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = max; // result is global max. 
        // 0 will divide array into subarrays

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) { // swap min and max
                int tmp = min;
                min = max;
                max = tmp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            
            res = Math.max(res, max);
        }
        return res;
    }
}