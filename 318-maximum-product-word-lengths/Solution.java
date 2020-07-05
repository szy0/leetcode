// works, failed the last test, TLE
class Solution {
    public int maxProduct(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (!hasCommonLetters(words[i], words[j])) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    private boolean hasCommonLetters(String A, String B) {
        char[] arrA = A.toCharArray();
        char[] arrB = B.toCharArray();
        for (char a : arrA) {
            for (char b : arrB) {
                if (a == b) return true;
            } 
        } 
        for (char b : arrB) {
            for (char a : arrA) {
                if (a == b) return true;
            } 
        }
        return false;
    }
}