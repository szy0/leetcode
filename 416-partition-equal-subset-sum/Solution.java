// this question has been turned into: can we find some elements in the array/list, making them
// sum up to a certain value (sum/2) ?
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 1) return false;
        int sum = 0;
        for (int n : nums) sum += n;
        Arrays.sort(nums); // necessary, and more efficient
        return (sum % 2 == 0) ? canSumUpToValue(nums, 0, sum/2, 0) : false;
    }

    // the following two methods work, but Time Limit Exceeded

    // private boolean canSumUpToValue(int[] nums, int index, int target, int tmp) {
    //     if (index == nums.length) return false;
    //     int n = nums[index];
    //     if (tmp + n == target) return true;
    //     return canSumUpToValue(nums, index + 1, target, tmp + n) || canSumUpToValue(nums, index + 1, target, tmp);
    // }

    // private boolean canSumUpToValue(int[] nums, int index, int target, int tmp) {
    //     if (index == nums.length || tmp > target) return false;
    //     int n = nums[index];
    //     if (tmp + n == target) return true;
    //     return canSumUpToValue(nums, index + 1, target, tmp + n) || canSumUpToValue(nums, index + 1, target, tmp);
    // }
}