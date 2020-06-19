class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int res = 0;
        char[] chars = s.toCharArray();
        
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true; // substring with length = 1
            res++;
        }

        int gap = 1; // substring with length = 2
        while (gap <= len -1) {
            for (int i = 0; i < len - gap; i++) {
                int a = i + 1;
                int b = i + gap - 1;
                if (gap >= 2) {
                    dp[i][i + gap] = dp[a][b] && (chars[i] == chars[i + gap]);
                } else {
                    // i.e. a special case for gap = 1
                    dp[i][i + gap] = (chars[i] == chars[i + gap]) ? true : false;
                }
                if (dp[i][i + gap]) res++;
                 
            }

            gap++;
        }
        return res;

    }
}