class Solution {
    public int lastRemaining(int n) {
        int step = 1;
        int head = 1;
        boolean l2r = true; // left to right
        while (n > 1) {
            if (l2r || n % 2 == 1) {
                head += step;
            }
            step *= 2;
            l2r = !l2r;
            n /= 2;
        }
        return head;
    }
}