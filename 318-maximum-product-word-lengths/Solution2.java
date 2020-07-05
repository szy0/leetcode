class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;
        int len = words.length;
        int[] toInt = new int[len];
        int res = 0;

        for (int i = 0; i < len; i++) {
            toInt[i] = wordToInt(words[i]);
        }
        for (int k = 0; k < len; k++) {
            for (int j = k + 1; j < len; j++) {
                if ((toInt[k] & toInt[j]) == 0) { // note: == has higher priority than &, so we must use () around &
                    res = Math.max(res, words[k].length() * words[j].length());
                }
            }
        }
        return res;
    }

    private int wordToInt(String word) {
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            res |= (1 << word.charAt(i) - 'a'); // the KEY point
        }
        return res;
    }
}