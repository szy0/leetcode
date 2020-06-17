class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        if (ss.length == 0 || pp.length == 0 || ss.length < pp.length) return res;
        // string p is actually non-empty

        int[] chars = new int[26]; // 26 letters from a-z
        for (char c : pp) {
            chars[c - 'a']++; // storing the amounts of a-z from string p
        }
        
        int start = 0, end = 0, len = pp.length, diff = len;
        // diff is the key point, it indicates the bi-directional difference between s and p
        // when diff == 0, we can know that all chars in (window) are in p, and all chars in p are
        // inside the (window)

        char tmp;
        // the initial window
        for (end = 0; end < len; end++) {
            tmp = ss[end];
            chars[tmp - 'a']--;
            if (chars[tmp - 'a'] >= 0) diff--; // if < 0, means this window owns extra char than the string p
            // in this case, diff can never be 0, note that we define diff = len
        }

        if (diff == 0) res.add(0);

        // moving the window, noting that the char at the start is removed, and the char at the end is added
        while (end < ss.length) {
            // handling the "start" char
            tmp = ss[start];
            if (chars[tmp - 'a'] >= 0) diff++; // since the start char WAS counted as a decrease of diff, now diff should be "increased back".

            chars[tmp - 'a']++;
            start++;


            // handling the "new end" char, the same as the operation before
            tmp = ss[end];
            chars[tmp - 'a']--;
            if (chars[tmp - 'a'] >= 0) diff--;
            if (diff == 0) res.add(start);

            end++;
        }
        return res;
        
    }
}