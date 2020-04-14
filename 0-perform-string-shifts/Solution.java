class Solution {
    public String stringShift(String s, int[][] shift) {
        if (s.length() <= 1) return s;
        for (int[] t : shift) {
            if (t[0] == 0) s = leftShift(s, t[1]);
            if (t[0] == 1) s = rightShift(s, t[1]);
        }
        return s;

    }
    private String leftShift(String s, int amount) {
        amount -= amount/s.length() * s.length();
        for (int i = 1; i <= amount; i++) {
           s = s.substring(1, s.length()) + s.charAt(0); // char will be auto-boxed to be string
           // substring endIndex will not be included, i.e. [start, end)
        }
       return s;

    }

    private String rightShift(String s, int amount) {
        amount -= amount/s.length() * s.length();
        for (int i = 1; i <= amount; i++) {
            s =  s.charAt(s.length() - 1) + s.substring(0, s.length() - 1); // auto-boxing
        }
        return s;
    }
}