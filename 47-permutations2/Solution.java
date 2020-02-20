import java.util.*;

// my first trial to implement a backtracking solution.

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> allRes = new ArrayList<List<Integer>>(); // result
        //List<Integer> one = new ArrayList<Integer>(); 
        if (nums == null || nums.length == 0) return allRes;

        int[] used = new int[nums.length];
        Arrays.sort(nums);

        backtrack(allRes,  new ArrayList<Integer>(), nums, used);
        return allRes;
    }

    private void backtrack(List<List<Integer>> allRes, 
                        ArrayList<Integer> tmp, int[] nums, int[] used) {
        if (tmp.size() == nums.length) {
            allRes.add(new ArrayList<Integer>(tmp)); // should not add tmp directly
            // tmp is a pointer, it will change afterwords.
            return;
        }

        for (int i=0; i < nums.length; i++) {
            if (i>0 && used[i-1] == 0 && nums[i-1] == nums[i]) continue;
            if (used[i] != 1) {
                tmp.add(nums[i]);
                used[i] = 1;
                backtrack(allRes, tmp, nums, used);
                tmp.remove(tmp.size()-1);
                used[i] = 0;
            }

        }
    }
}



