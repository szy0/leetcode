// inspired by other coder
// this is actually three-pointers, as we use p1, p2 and a index
// the concept of multi-pointers is what really matters
class Solution {
    public void sortColors(int[] nums) {
        if (nums.length <= 1) return;

        int p1 = 0;
        int p2 = nums.length - 1; // two pointers
        int index = 0; // current index

        // one pass
        while (index <= p2) {
            // moving zero to the front of this array
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }

            // moving two to the rear of this array
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }
    }
}




// // two pointers
// // this solution requires loop-in-loop, not very satisfying O(n^2)
// // it is similar to quick sorting
// class Solution {
//     public void sortColors(int[] nums) {
//         if (nums.length <= 1) return;

//         int p1 = 0;
//         int p2 = nums.length - 1;

//         while (p1 < nums.length - 1) {
//             while (p1 < p2) {
//                 if (nums[p1] > nums[p2]) {
//                     int temp = nums[p2];
//                     nums[p2] = nums[p1];
//                     nums[p1] = temp;
//                 }
//                 p2--;
//             }

//             p1++;
//             p2 = nums.length - 1;
//         }
//     }
// }


// a rather straight-forward solution, counting the amount of zeros and ones (also twos)
// class Solution {
//     // two pass
//     public void sortColors(int[] nums) {
//         int zero = 0, one = 0;
//         for (int k : nums) {
//             if (k == 0) zero++;
//             if (k == 1) one++;
//         }

//         for (int i = 0; i < nums.length; i++) {
//             if (i < zero) 
//                 nums[i] = 0;
//             else if (i < zero + one) 
//                 nums[i] = 1;
//             else 
//                 nums[i] = 2;
//         }

//     }
// }