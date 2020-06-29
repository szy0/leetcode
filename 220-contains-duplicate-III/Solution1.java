// in some test cases, there are large number like Integer.MAX_VALUE
// so we use long/Long here to avoid overflow

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) return false;
        if (k <= 0 || t < 0) return false;
        
        // must use TreeSet<> rather than Set<> in the left side
        TreeSet<Long> set = new TreeSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (i >= k + 1) set.remove((long)nums[i - k - 1]); 
            // remove an object
            // the set is always sorted

            Long floor = set.floor((long)nums[i]); 
            Long ceiling = set.ceiling((long)nums[i]); 
            // long is primitive type, cannot be null
            // while this two methods could return null
            // so we use Long floor, Long ceiling

            if ((floor != null && nums[i] - floor <= t) ||
                    (ceiling != null && ceiling - nums[i] <= t)) {

                return true;
            }

            set.add((long)nums[i]);
        }
        return false;
    }
}