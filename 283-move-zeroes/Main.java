public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums ={0,1,0,3,12};
        printArr(nums);
        s.moveZeroes(nums);
        printArr(nums);

    }

    private static void printArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        return;
    }
}