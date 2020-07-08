// improved from last solution
// we sort the nums first, so that duplicates will be adjacent
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // important
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>());
        backtrack(nums, list, new ArrayList<Integer>(), 0);
        return list;
    }

    private void backtrack(int[] nums, List<List<Integer>> list, List<Integer> tmp, int index) {
        if (nums == null || index >= nums.length) return; // for corner case, and stopping condition
        tmp.add(nums[index]);
    
        list.add(new ArrayList<Integer>(tmp));
        backtrack(nums, list, tmp, index + 1);

        // when there are duplicate numbers, skipping them
        // e.g. nums= [1,2,2]    {1,2 (first 2)} and {1,2 (second 2)} are the same
        while (index + 1 < nums.length && nums[index + 1] == nums[index]) 
            index++;

        tmp.remove(tmp.size() - 1);
        backtrack(nums, list, tmp, index + 1);
    }
}