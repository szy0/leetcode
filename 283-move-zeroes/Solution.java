// two pointers
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int p1 = 0;
        int p2 = 0;
        int zeroes = 0;

        while (p1 < nums.length) {
            if (nums[p1] == 0) {
                while (p1 < nums.length && nums[p1] == 0) {
                    zeroes++;
                    p1++;
                }
                if (p1 >= nums.length) break;
            }
            
            nums[p2] = nums[p1];
            p1++;
            p2++;
        }

        //System.out.println("p1 p2 zeros: " + p1 + " " + p2 + " " + zeroes);
        for (int i = 0; i < zeroes; i++) {
            nums[nums.length - 1 - i] = 0;
        }
        return;
    }
}
