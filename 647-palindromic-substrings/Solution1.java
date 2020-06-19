class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        for (int i = 0; i < s.length(); i++) {
            extendCheck(s, i, i);       // checking palindromic by extending from  charAt(i), for all odd substrings
            extendCheck(s, i, i + 1); // checking palindromic by extending from two-digit substring (i, i + 1), for all even substrings
        }
        return count;

    }
    private void extendCheck(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}