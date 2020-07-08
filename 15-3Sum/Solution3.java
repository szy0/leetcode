// after nearly half a year, I tried this problem again
// two-pointers

// I solved this problem kinda smoothly, but slow (592ms)
// then I made some improvement, a lot faster (49ms)
// improve further, 43ms
// actually I do not need hashset
// 35ms, I guess that is my limit
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
 
        if (nums == null || nums.length <= 2 || nums[0] > 0) return res;
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i >= 1 && nums[i] == nums[i-1]) continue;
            res.addAll(helper(nums, i, i + 1, nums.length - 1));
        }
        return res;
    }

    // two-pointer
    private List<List<Integer>> helper(int[] nums, int index, int left, int right) {
        int sum = -nums[index]; // now it is 2sum problem
        List<List<Integer>> ret = new ArrayList<>();
        
        while (left < right) {
            if (nums[left] + nums[right] > sum) right--;
            else if (nums[left] + nums[right] < sum) left++;
            else {
                List<Integer> tmp = Arrays.asList(nums[index], nums[left], nums[right]);
                ret.add(tmp);
                left++;
                right--;
                while(left < right && nums[left] == nums[left - 1]) left++; // note that these two sentence should be placed only under condition "== sum"
                while(left < right && nums[right] == nums[right + 1]) right--;
            }
        }
        return ret;
    }
}