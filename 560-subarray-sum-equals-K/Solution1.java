import java.util.Map;

// go review author's solution No.4
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>(); // <sum, occurences of sum>
        int sum = 0;
        int count = 0;
        map.put(0, 1); // one extra space in case nums[0] == k;
        // similar to dp[nums.length + 1];
        for (int n : nums) {
            sum += n;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}