// binary search solution, inspired by another coder

// a normal array [1,2,3,4,5,6,7]   if we have duplicates[1,2,2,3,4,5,7]
// we can see that there are 4 values (1,2,2,3) < the mid value (4)
// there are only 2 values (5,7) > the mid value (4)
// it is unbalanced.

// we count the value < mid and > mid, which half has more values, duplicate happens in that half

class Solution {
    // modified from another coder's solution
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 1, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int a : nums) {
                if (a <= mid) count++;
            }
            if (count <= mid) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }




    // my own implement

    // public int findDuplicate(int[] nums) {
    //     if (nums == null || nums.length == 0) return -1;
    //     int right = nums.length; // max value
    //     int left = 1;

    //     while (left < right) {
    //         int count = 0;
    //         int mid = (left + right) / 2;

    //         if (left == mid) {    
    //             for (int n : nums) {
    //                 if (n == left) count++;
    //             }
    //             if (count > 1) return left;
    //             else return right;
    //         }
         
    //         for (int n : nums) {
    //             if (n >= left && n < mid) count++;
    //         }

    //         if (count <= mid - left) 
    //             left = mid;
    //         else 
    //             right = mid;            
    //     }
    //     return right;
    // }
}