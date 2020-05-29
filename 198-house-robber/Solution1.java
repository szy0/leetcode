// a failed attempt

class Solution1 {

    public int rob(int[] nums) {
        boolean[] robbed = new boolean[nums.length];
        int[] currentMax = new currentMax[nums.length];
        robbed[0] = true;
        currentMax[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                if (nums[1] > nums[0]) {
                    robbed[0] = false;
                    robbed[1] = true;
                    currentMax[1] = nums[1];
                } else {
                    currentMax[1] = nums[0];
                }
            }

            if (i == 2) {
                if (nums[2] + nums[0] > nums[1]) {
                    robbed[0] = true;
                    robbed[1] = false;
                    robbed[2] = true;
                    currentMax[2] = nums[0] + nums[2];
                } else {
                    currentMax[2] = nums[1];
                }
            }

            if (i >= 3) {
                if (!robbed[i-1]) {
                    currentMax[i] = currentMax[i-1] + nums[i];
                    robbed[i] = true;
                } else {
                    if (nums[i-1] < nums[i]) {
                        if (robbed[i-3]) {
                            robbed[i-1] = false;
                            robbed[i] = true;
                            currentMax[i] = currentMax[i-2] + nums[i];
                        }
                        if (!robbed[i-3]) {
                            robbed[i-2] = true;
                            robbed[i-1] = false;
                            robbed[i] = true;
                            currentMax[i] = currentMax[i-3] + nums[i-2] + nums[i];
                        }
                        

                    }
                }
            }

        }
    }
    

    // public int rob(int[] nums) {
    //     int[] maxMoney = new int[nums.length];
    //     maxMoney[0] = nums.length[0];
    //     for (int i = 1; i < nums.length; i++) {
    //         maxMoney[i] = Math.max(maxMoney[i-1], nums[i]);
    //     }
    // }
}