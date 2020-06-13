// inspired by coder "hu19"
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int len = nums.length;
        for (int i = 0; i < len; i++) nums[(nums[i]-1) % len] += len;
        for (int j = 0; j < len; j++) {
            if (nums[j] <= len) {
                res.add(j + 1);
            }
        }
        return res;
    }
}