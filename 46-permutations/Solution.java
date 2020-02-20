import java.util.ArrayList;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<Integer> one = new ArrayList<Integer>();
        List<List<Integer>> all = new ArrayList<List<Integer>>();

        if (len == 0) {
            all.add(one);
            return all;
        }
        if (len == 1) {
            one.add(nums[0]);
            all.add(one);
            return all;
        }

        for (int k : nums) {
            int[] nextArray = removeElement(nums, k);
            for (List<Integer> m : permute(nextArray)) {
                m.add(0,k); // add to the beginning
                all.add(m);
            }
            
        }
        return all;
        


    }

    public int[] removeElement(int[] nums, int val) { // nums is a collection of distinct integers.
        int[] result = new int[nums.length-1];
        boolean found = false;

        for (int k=0; k<nums.length-1; k++) {
            if (!found) {
                if (nums[k] != val) {
                    result[k] = nums[k];
                } else {
                    found = true;
                    result[k] = nums[k+1];
                }
            } else {
                result[k] = nums[k+1];
            }
            
        }
        return result;
    }

}