import java.util.*;

// class Solution {
//     public int singleNumber(int[] nums) {
//         Set<Integer> temp = new HashSet<>();
//         for (int i : nums) {
//             if (temp.contains(i)) {
//                 temp.remove(Integer.valueOf(i));
//             } else {
//                 temp.add(i);
//             }
//         }
//         return (int)temp.toArray()[0];
//     }
// }

class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}