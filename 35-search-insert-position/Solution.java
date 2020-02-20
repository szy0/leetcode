class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len==0) return 0;
        if (len==1) return (nums[0]>=target)?0:1;
        
        int i = 0;
        while(i <= len-1) {
            if (nums[i] >= target) {
                return i;
            }
            i++;
        }
        return len;
        
    }
}