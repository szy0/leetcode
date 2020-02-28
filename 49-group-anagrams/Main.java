import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Solution s = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = s.groupAnagrams(strs);
        for (List<String> ls : res) {
            for (String k : ls) System.out.print(k + " ");
            System.out.println();
        }

        if (s.isMatched("eat", "tea"))
            System.out.println("true!!");
    }
}