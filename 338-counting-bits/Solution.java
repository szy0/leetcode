class Solution {
    // a slightly improved version
    public int[] countBits(int num) {

        int current = 1; // 2^0 = 1

        int[] res = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            if (i >= current*2) {         
                current *= 2;   
            }
            int temp = i - current;
            res[i] = 1 + res[temp];
        }
        return res;
    }
    
    // public int[] countBits(int num) {
    //     int power = 0;
    //     int[] res = new int[num + 1];

    //     for (int i = 1; i <= num; i++) {
    //         if (i >= (int)Math.pow(2, power+1)) {         
    //             power ++;   
    //         }
    //         int temp = i - (int)Math.pow(2, power);
    //         res[i] = 1 + res[temp];
    //     }
    //     return res;
    // }
}