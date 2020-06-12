import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // entry <num, amount of this num>
        Map<Integer, Integer> map = new HashMap();
        for (int n : nums) {
            if (map.keySet().contains(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, (e1, e2) -> e2.getValue() - e1.getValue());

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();
        }
        return res;

        // Collections.sort(map, (Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2) -> 
        // m1.getValue() - m2.getValue());

    }
}