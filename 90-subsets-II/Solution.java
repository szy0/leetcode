class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        set.add(new ArrayList<Integer>());

        backtrack(nums, set, new ArrayList<Integer>(), 0);
        return new ArrayList<List<Integer>>(set); // set -> list
    }

    private void backtrack(int[] nums, Set<List<Integer>> set, List<Integer> tmp, int index) {
        if (nums == null || index >= nums.length) return; // for corner case, and stopping condition
        tmp.add(nums[index]);

        ArrayList<Integer> sortedTmp = new ArrayList<Integer>(tmp); // make a copy
        Collections.sort(sortedTmp);
        set.add(sortedTmp); // list{1,2,2} and list{2,1,2} are the same to us, but different to set

        backtrack(nums, set, tmp, index + 1);
        tmp.remove(tmp.size() - 1);
        backtrack(nums, set, tmp, index + 1);
    }
}