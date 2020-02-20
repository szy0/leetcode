import java.util.*;

// it works, but not efficient
class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        if (len == 2) {
            int a = nums[0];
            int b = nums[1];
            if (a >= 0 && b >= 0) 
                return a + b;
            else 
                return (a > b) ? a : b; // one positive one negative or two negatives
        }

        ArrayList<Integer> sums = new ArrayList<>();
        int curSign = 0;
        int curSum = nums[0];
        int maxVal = nums[0];

        if (nums[0] < 0) 
            curSign = -1;
        else 
            curSign = 1;

        for (int i = 1; i < len; i++) {
            if (isSameSign(curSign, nums[i])) {
                curSum += nums[i];
            } else {
                sums.add(curSum);
                curSign *= -1;
                curSum = nums[i];
            }
            if (nums[i] > maxVal) maxVal = nums[i];
        }
        sums.add(curSum);
        if (maxVal <= 0) return maxVal; // in case it is a all-negative arr
        //maxMain.printList(sums);

        if (sums.size() >= 3) {
            if (sums.get(0) < 0) 
                sums.remove(0); // remove(index)   note int -> index and <Integer> -> object
            if (sums.get(sums.size()-1) < 0) 
                sums.remove(sums.size()-1); // remove(index)
            // till this step could only be +-+-+ ....| +-+ | + 
        }
        //maxMain.printList(sums);


        if (sums.size() >= 3) {
            int len2 = sums.size();
            int head = sums.get(0);
            int tail = sums.get(len2-1); // both positive
            if (head >= tail) {
                sums.set(len2-2, sums.get(len2-2) + tail);
                sums.remove(len2 - 1);
            } else {
                sums.set(1, sums.get(1) + head);
                sums.remove(0);
            }
        }
        
        return maxSubArray(listToArr(sums));

    }

    private boolean isSameSign(int a, int b) {
        if (a < 0) {
            return (b < 0) ? true : false;
        } else {
            return (b >= 0) ? true : false;
        }
    }

    private int[] listToArr(ArrayList<Integer> list) {
        int len = list.size();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}