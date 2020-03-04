import java.util.*;

// inspired by another coder.

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        if (strs == null || strs.length == 0) return res;
    
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String tag = String.valueOf(chars);
            if (map.containsKey(tag)) {
                map.get(tag).add(s); // does this directly add into the map?
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(tag, list);
            }
        }

        
        for (List<String> ls : map.values()){
            res.add(ls);
        }
        
        return res;
    }
}