class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
    
        int len = nums.length;
        int reachable = 0; // for global index
        for (int i = 0; i <= len-1; i++) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]); // base = i; extended reachable = nums[i]
        }
        return true;
    }
}