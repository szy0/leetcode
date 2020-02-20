public class srMain {
    public static void main(String[] args) {
        // int[] a = giveMe();
        // for (int k : a){
        //     System.out.println(k);
        // }
        Solution s = new Solution();
        //int[] nums = {1,1,1,2,3,4,5,8,14,15,15,15,15,15,20,20,20,21,21,25,25,100,200,300};
        //int target = 122;
        // int[] nums = {0,14,14,14,14,15,16,22,23,24,26,27,28,28,28,30};
        // int target = 14;

        int nums = {0,0,1,1,1,2,3,4,4,5,6,7,7,7,8,8,8,8,9,9,10};
        int target = 4;

        // int[] nums = {5,7,7,8,8,10};
        // int target = 8;
        
        // int[] nums ={1,5};
        // int target = 4;
        
        int[] positions = s.searchRange(nums, target);
        for (int k : positions){
            System.out.print(k + " ");
        }
        System.out.println("\n"); // [9,13]
        
        
    }

    public static int[] giveMe() {
        int[] a = {1,2};
        return a;
    }
}