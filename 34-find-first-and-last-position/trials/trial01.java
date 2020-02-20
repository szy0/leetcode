class trial01 {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] positions = {0, len-1};
        int[] notFound = {-1,-1};

        int left = len/2;
        int right = len/2;

        if (nums[0] < target) {
            while (nums[left] >= target) {
                left /= 2;
            }

        }
       
        if (nums[len-1] > target) {
            while (nums[right] <= target) {
                right = (right + len -1)/2;
            }
        }
   
        if (left > 0) {
            positions[0] = searchRange(nums, nums[left])[1] + 1;
        } 

        if (right < len-1) {
            positions[1] = searchRange(nums, nums[right])[0] -1;
        }
        return positions;
    }

    //public boolean isStartPos(int[] nums, )
}