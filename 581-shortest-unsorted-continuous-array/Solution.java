class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int p1 = 0;
        int p2 = nums.length - 1;

        // finding the range of unsorted array
        while (p1 < p2) {
            boolean changed = false;
            if (nums[p1 + 1] >= nums[p1]) {
                p1++;
                changed = true;
            }
            if (nums[p2 - 1] <= nums[p2]) {
                p2--;
                changed = true;
            }
            if (!changed) break;
        }
        if (p2 <= p1) return 0;


        // finding the max and min inside the unsorted part
        int min = nums[p1];
        int max = min;
        for (int i = p1; i <= p2; i++) {
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) max = nums[i];
        }

        // the len could be added
        int len = p2 - p1 - 1;
        while (p2 <= nums.length-1 && max > nums[p2]) {
            len++;
            p2++;
        }
        while (p1 >= 0 && min < nums[p1]) {
            len++;
            p1--;
        }

        return len; // p2 - p1 could be -1 if the input array is sorted

    }
}