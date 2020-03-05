import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums == null || nums.length == 0) return res;

        res.remove(0);
        Arrays.sort(nums);
        backtrack(nums, res, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> temp, int start) {
        if (temp.size() <= nums.length) {
            res.add(new ArrayList<Integer>(temp));  // still not clear about this 
            //backtrack(nums, res, temp);
            // the new means create a new same list as temp?

        }

        for (int i = start; i <= nums.length - 1; i++) {
            temp.add(nums[i]);
            backtrack(nums, res, temp, i + 1);
            temp.remove(temp.size()-1); // remove by index
        }
        return;
    }
}