class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int count = 0;
        if (len==0) return 0;
    
        for (int k=0; k<len; k++) {
            if (nums[k] == val) { // swap
                int index = 1;
                while (k+index < len) {
                    if (nums[k+index] != val) {
                        nums[k] = nums[k] + nums[k+index];
                        nums[k+index] = nums[k] - nums[k+index];
                        nums[k] = nums[k] - nums[k+index];
                        break;
                    } else {
                        index ++;
                    }
                }

            }
        }

        for (int k=0; k<len; k++) {
            if (nums[k] != val) { 
                count ++;
            } else {
                break;
            }
        }
        return count;
    }
}