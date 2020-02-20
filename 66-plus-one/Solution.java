class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] res = new int[len + 1];
        res[0] = 1;

        for (int i = len - 1; i >= 0 ; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        return (digits[0] == 0)? res : digits;
    }
}