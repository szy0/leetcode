class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return 1;

        int currentNum = nums[0];
        int currentIndex = 0;
        int count = 1;



        for (int k =1; k<len; k++) {
            if (currentNum == nums[k]) {
  
            } else {
                currentNum = nums[k];
                currentIndex += 1;
                nums[currentIndex] = currentNum;
                count ++;
            }
        }

        // after in-place removing duplicates
        return count;
    }
}