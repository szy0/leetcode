import java.util.*;

// it works, but too slow.
// O(n^2)?

class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int len = strs.length;
        if (len == 0) return res;
        List<String> one = new ArrayList<>();
        one.add(strs[0]);
        res.add(one); // is this OK?
        for (int i = 1; i < len; i++) {
            String s = strs[i];
            boolean added = false;
            for (int k = 0; k < res.size(); k++) {
                if (isMatched(s, res.get(k).get(0))) {
                    List<String> temp = res.get(k);
                    temp.add(s);
                    res.set(k, temp); // will this change the value of ordinary list>
                    added = true;
                    break;
                }
                   
            }
            if (added == false) {
                List<String> two = new ArrayList<>();
                two.add(s);
                res.add(two);
            }
        }
        return res;
    }

    public boolean isMatched(String a, String b) {
        if (a.length() != b.length()) return false;
        String[] as = a.split("");
        String[] bs = b.split("");
        Arrays.sort(as);
        Arrays.sort(bs);
        for (int i = 0; i < as.length; i++) {
            if (!as[i].equals(bs[i])) return false;
        }
        return true; // two arrays equal??
    }

}