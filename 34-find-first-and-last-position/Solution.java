class Solution {
    // there are numerous tricks, details, traps in the solution
    // I like the main idea, the partition concept, but I do not think
    // my solution is a good one.
    private int debug = 1;
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length; 
        int mid = len/2;
        int start = 0;
        int end = len - 1;

        int[] positions = new int[2];
        int[] notFound = {-1, -1};
        
        if (len==0) return notFound; // I used this line, not to eliminate a special case
        // which is nums is empty, but to ensure that the following codes can run

        int count = 0;
        while (nums[mid] != target) {
            if (nums[mid] > target) {
                end = mid;
                mid /= 2;
            } else {
                mid = (mid + end + 1)/2; // in case, mid stuck in mid = len -2
                // (len -2 + len -1 )/2 = len -1; so mid would not change if I did not
                // put end + 1 here;
            }
            count ++;
            if (count > len+1) {return notFound;}
            if (debug == 1) System.out.println("in-mid");

        }

        if (debug == 1) System.out.println("after-mid");

        if (nums[0] != target) {
            while (true) {
                while (nums[start+1] != target) {
                    start = (start + mid)/2;
                 // (6+7)/2 =6, start may not increase, so need to manually ++
                }
                if (nums[start] == target) {
                    mid = start;
                    start = 0;
                } else break;
                if (debug == 1) System.out.println("in-start");
            }
        }
        if (debug == 1) System.out.println("after-start");

        if (nums[len-1] != target) {
            while (true) {
                while (nums[end] != target) {
                    end = (end + mid)/2; // no need for end to --
                }
                if (nums[end+1] == target) {
                    mid = end;
                    end = len-1;
                } else break;
                if (debug == 1) System.out.println("in-end");
            }
        }

        if (nums[0] == target) positions[0] = 0;
        else positions[0] = start + 1;

        positions[1] = end;
        return positions;

    }
}