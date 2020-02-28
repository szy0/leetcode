class Solution {
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int b = 2;
        int c = 3;

        for (int i = 4; i <= n; i++) {
            int temp = c;
            c = b + c;
            b = temp;
        }
        return c;
    }
}