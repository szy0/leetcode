class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }

    // case1: we rob the 1st house, but not the last one
    // case2: we do not rob the 1st house, but (we may rob) the last one
    private int helper(int[] nums, int start, int end) {
        int prevRob = nums[start];
        int prevNot = 0;
        for (int i = start + 1; i <= end; i++) {
            int tmp = prevRob;
            prevRob = prevNot + nums[i]; // current Rob
            prevNot = Math.max(tmp, prevNot); // current not rob
        }
        return Math.max(prevRob, prevNot);
    }
}