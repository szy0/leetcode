public class MainClass {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] nums = {3,2,3,3,2,5};
        int val = 3;
        int amount = s.removeElement(nums, val);
        for (int k = 0; k<amount; k++) {
            System.out.print(nums[k]);
            if (k != amount-1) {
                System.out.print(",");
            } else {
                System.out.print("\n");
            }
            
        }
    }
}