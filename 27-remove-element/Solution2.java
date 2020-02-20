class Solution2 {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;

        for (int k=0; k<len; k++) {
            while (nums[k] == val && k < len) {  
                nums[k] = nums[len-1];
                len--;
            }
        }
        return len;

    }
}