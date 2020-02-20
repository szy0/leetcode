import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len <= 1) return;
        if (len == 2) {
            nums[0] = nums[1] + nums[0];
            nums[1] = nums[0] - nums[1];
            nums[0] = nums[0] - nums[1];
            return;
        }
        
        if (nums[len-2] < nums[len-1]) {
            nums[len-2] = nums[len-1] + nums[len-2];
            nums[len-1] = nums[len-2] - nums[len-1];
            nums[len-2] = nums[len-2] - nums[len-1];
            return;
        } 

        for (int k = len-2; k>=1; k--) {
            if (nums[k-1] < nums[k]) {
                for (int p=len-1; p>=k; p--) {
                    if (nums[p] > nums[k-1]) {
                        int temp = nums[p];
                        nums[p] = nums[k-1];
                        nums[k-1] = temp; 
                        break;
                    }
                }

                for (int m=0; m<(len-k)/2; m++) { // sort from [k to len-1], this type of swapping is much clearer
                    int temp = nums[m+k];
                    nums[m+k]  =  nums[len-1-m];
                    nums[len-1-m] = temp;
                }
                return;
            }
        }


        Arrays.sort(nums);
        return;
    }     
}




    // swap method is a totally wrong idea. It can not be used because I will lose the value of a first
    // when I call a = swap(a,b)[0];
    
    // static int[] swap(int a, int b) {
    //     int[] t = new int[2];
    //     t[0] = b;
    //     t[1] = a;
    //     return t;
    // }

    // public static void main(String[] args) {
    //     int a = 5;
    //     int b = 2;
    //     a = swap(a, b)[0];
    //     b = swap(a, b)[1];
    //     System.out.printf("a = %d, b = %d\n",a,b);

    //     for (int i:swap(a, b)) {
    //         System.out.println(i);
    //     }
    // }