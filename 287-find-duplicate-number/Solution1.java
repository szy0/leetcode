// go see coder "echoxiaolee"s post and the comment from "if963" below
// tortoise and Hare algorithm
class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int slow = nums[0];
        int fast = nums[nums[0]];
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;

    }
}