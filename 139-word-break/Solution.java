// backtracking works but can be extremely slow when s is relatively long
// dp can be used. We only want to only "if" we can do work-break, we dont care 
// the actual combination of words
class Solution {
    // dynamic programming
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> dict = new HashSet<>();
        dict.addAll(wordDict);

        for(int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = dp[j] && dict.contains(s.substring(j, i));
                if (dp[i]) break;
            }
        }
        return dp[s.length()];
    }



    // public boolean wordBreak(String s, List<String> wordDict) {
    //     return backtrack(s, wordDict, 0);
    // }

    // private boolean backtrack(String s, List<String> wordDict, int currentIndex) {
    //     for (int i = currentIndex; i < wordDict.size(); i++) {
    //         String word = wordDict.get(i);
    //         if (s.length() >= word.length()) {
    //             String sub = s.substring(0, word.length());
    //             if (sub.equals(word)) {
    //                 if (s.length() == word.length()) {
    //                     // i.e. s equals to this word
    //                     return true;
    //                 } else {
    //                     // i.e. this word is a true substring of s
    //                     return backtrack(s.substring(word.length()), wordDict, 0) || backtrack(s, wordDict, i + 1);
    //                 }
    //             }
    //         }
          
    //     }
    //     return false;
    // }


}