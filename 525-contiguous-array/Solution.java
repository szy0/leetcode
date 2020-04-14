import java.util.*;
// from other coders
// a little modification
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0, max = 0; // max len, calculated from index i - j
        
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == 0) sum--;
            if (nums[k] == 1) sum++; 
            // regarding "0" as "-1" in order to know their amounts
            // if sum == 0, it means the amounts of 0 and 1 are the same.
            // should not modify the array using "nums[k] = -1" when it is zero
   
            if (sumToIndex.keySet().contains(sum)) {
                max = Math.max(max, k - sumToIndex.get(sum));
            } else {
                sumToIndex.put(sum, k);
            }
        }
        return max;

    }
}