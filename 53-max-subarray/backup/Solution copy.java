import java.util.*;

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
        }
        sums.add(curSum);

        // if (sums.size() > 3) {
        //     if (sums.get(0) < 0) 
        //         sums.remove(sums.get(0)); // remove(index)   note int -> index and <Integer> -> object
        //     if (sums.get(sums.size()-1) < 0) 
        //         sums.remove(sums.get(sums.size()-1)); // remove(index)
        // }

        // if (sums.size() == 3 && sums.get(1) < 0) {
        //     int a = sums.get(0);
        //     int b = sums.get(2);
        //     if (a + sums.get(1) > 0 || b + sums.get(1) > 0) 
        //         return a + b + sums.get(1);
        //     else 
        //         return (a > b) ? a : b;

        // }
        
        // if (sums.size() >= 3) {
        //     if (sums.get(0) < 0) 
        //         sums.remove(0); // remove(index)   note int -> index and <Integer> -> object
        //     if (sums.get(sums.size()-1) < 0) 
        //         sums.remove(sums.size()-1); // remove(index)
        //     if (sums.size() >= 3) {
        //         if (sums.get(0) <= sums.get(2)){
        //             sums.set(0, sums.get(0 + sums.get(1)));
        //             sums.remove(1);
        //         }
        //     if (sums.size() >= 3) {
        //         if (sums.get(0) <= sums.get(2)){
        //             sums.set(0, sums.get(0 + sums.get(1)));
        //             sums.remove(1);
        //         }
        //     }
          
        // }

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