// a bunch of special cases, edge cases, really annoying
// to handle them is so disgusting
// I give up, I do not want to waste time on them

// this solution does NOT work!!!!!
// although, I think the main idea here is ok

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        if (nums.length == 2) {
            if (nums[0] == target) return 0;
            if (nums[1] == target) return 1;
            return -1;
        }

        int end = nums[nums.length - 1];
        int mid = (nums.length - 1)/2; 
        while (mid > 0 && nums[mid] < nums[mid + 1] && nums[mid] > nums[mid - 1]) {
            if (nums[mid] < end) 
                mid = (0 + mid)/2;
            else 
                mid = (mid + nums.length - 1)/2;
        } // finding the index of pivot

        if (mid > 0 && nums[mid] < nums[mid + 1]) mid--;

        if (mid == 0) { // involving the special case: the whole arr is in ascending order
            if (nums[0] == target) return 0;
            else return binarySearch(nums, 1, nums.length -1, target);
        } else {
            if (target < nums[mid + 1] || target > nums[mid]) return -1;
            else {
                if (target > end) 
                    return binarySearch(nums, 0, mid, target);
                else 
                    return binarySearch(nums, mid + 1, nums.length - 1, target); 
            }
        }
      

    }

    private int binarySearch(int[] nums, int startIndex, int endIndex, int target) {
        int mid = (startIndex + endIndex)/2;
        while (startIndex <= endIndex - 2) {
            if (nums[mid] < target) {
                startIndex = mid;
                mid = (mid + endIndex)/2;
            }
            if (nums[mid] > target) {
                endIndex = mid;
                mid = (startIndex + mid)/2;
            }
            if (nums[mid] == target) return mid;
        }
        if (nums[mid] == target) return mid; // for special case when the target is at startIndex
        if (nums[mid + 1] == target) return mid + 1; // for special case when the target is at endIndex
        return -1;
    }
    
}