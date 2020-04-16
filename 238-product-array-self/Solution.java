// a straight forward solution, but division is used here, did not meet the requirement
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        int product = 1;
        int numOfZeros = 0;
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numOfZeros++;
                index = i;
                if (numOfZeros == 2) return output;
            } else {
                product *= nums[i];
            }
        }

        if (numOfZeros == 1) {
            output[index] = product;
        } else {
            for (int i = 0; i < nums.length; i++) {
                output[i] = product / nums[i]; // can I solve this problem without using division?
            }
        }

        return output;
    }
}