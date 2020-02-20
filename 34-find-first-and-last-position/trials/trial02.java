class Solution02 {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int start = 0;
        int end = len-1;
        int mid = len/2;

        int[] pos = {start,end};
        int[] notFound = {-1, -1};

        if (len == 0 || nums[0] > target || nums[len-1] < target) {
            return notFound;
        }

        
        int count = 0;
        while (nums[mid] != target) {
            count++;
            if (count > len) return notFound; // means nums does not contain target
            while (nums[mid] > target) {
                mid /= 2;
            }
            while (nums[mid] < target) {
                mid = (mid + len -1)/2;
            }
        }
        System.out.println("mid");
        

        if (nums[0] != target) {
            while (!(nums[start] == target && nums[start-1]<target)) {
                
                while (nums[start] < target) {
                    start = (start + mid)/2;
                    start++;
                }
                while (nums[start] > target) {
                    start /= 2;
                    
                }
                start --;
            }
        }
        System.out.println("start");
        if (nums[len-1] != target) {
            while (!(nums[end] == target && nums[end+1]>target)){
                
                while (nums[end] < target) {
                    end = (end + len-1)/2;
                    end ++;
                    
                }
                while (nums[end] > target) {
                    end = (end + mid)/2;
                }
                end ++;
            }
        }

        pos[0] = start;
        pos[1] = end;
        return pos;

    }
}