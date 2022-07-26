public class Solution1 {
    public int numberOfSubstrings(String s) {
        int[] count = {0, 0, 0};
        int res = 0;
        int p1 = 0;
        int p2 = 0;
        while (true) {
            count[s.charAt(p2) - 'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                res += s.length() - p2;
                count[s.charAt(p1) - 'a']--;
                p1++;
            } 
            p2++;
            if (p2 == s.length()) break;
        }
        return res;
    }
}
