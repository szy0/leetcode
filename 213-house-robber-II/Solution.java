class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[][] rob1 = new int[nums.length][2]; // if robbing house 1, the last house cannot be robbed
        int[][] notRob1 = new int[nums.length][2]; // if not robbing house 1, we could (but may not) rob the last house
        
        rob1[0][0] = nums[0];
        rob1[0][1] = nums[0];
        
        
        for (int i = 1; i < nums.length; i++) {
            rob1[i][0] = Math.max(rob1[i-1][0], rob1[i-1][1]);
            rob1[i][1] = rob1[i-1][0] + nums[i];
            
            rob1[1][1] = 0; // important, actually only need once

            notRob1[i][0] = Math.max(notRob1[i-1][0], notRob1[i-1][1]);
            notRob1[i][1] = notRob1[i-1][0] + nums[i];
        }
        
        int a = rob1[nums.length - 1][0]; // robbing house 1
        int b = notRob1[nums.length - 1][0]; // not robbing last house
        int c = notRob1[nums.length - 1][1]; // robbing last house
        return Math.max(a, Math.max(b, c));
    }
}