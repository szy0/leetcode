class Solution {
    // my solution, checking from end of the array
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return true;
        
        int len = nums.length;
        for (int i = len - 2; i >= 1; i--) {
            if (nums[i] >= (len - 1 - i)) {
                return canJumpHere(nums, i);
            }
        }

        return (nums[0] >= len - 1) ? true : false;
    }

    private boolean canJumpHere(int[] nums, int mid) {
        for (int i = mid - 1; i >= 0; i--) {
            if (nums[i] >= (mid - i)) {
                return canJumpHere(nums, i);
            }
        }
        return (mid == 0) ? true : false;
    } 
}