// recursion works but slow (>500ms)
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        return countWays(nums, 0, S, 0);
    }
    private int countWays(int[] nums, int index, int S, int tmp) {
        if (index == nums.length) {
            return tmp == S ? 1 : 0;
        }
        int a = countWays(nums, index + 1, S, tmp - nums[index]);
        int b = countWays(nums, index + 1, S, tmp + nums[index]);
        return a + b;
    }
}