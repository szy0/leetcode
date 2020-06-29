// this solution did not pass the last test, which is a quite large array
// and I got Time Limit Exceeded.

// I did not know the floor() and ceiling() methods before
// go see Solution1.java

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) return false;
        
        TreeSet<Integer> set = new TreeSet<>(); // TreeSet is the key point.
        set.add(nums[0]); // to make last() work
        
        for (int i = 1; i < nums.length; i++) {
            if (i >= k + 1) set.remove(nums[i - k - 1]); // remove an object
            // the set is always sorted
            
            Iterator<Integer> it = set.iterator();
            while (it.hasNext()) {
                int a = it.next();
                if (Math.abs((long)a - (long)nums[i]) <= t) return true;
                // converting to long in case out of range of int
            }
            set.add(nums[i]);
        }
        return false;
    }
}