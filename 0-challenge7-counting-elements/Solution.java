import java.util.*;
class Solution {
    public int countElements(int[] arr) {
        if (arr == null || arr.length <= 1) return 0;

        int res = 0; // result
        Map<Integer, Integer> map = new HashMap<>(); // entry: {element in arr, amount of this element}
        for (int k : arr) {
            if (!map.keySet().contains(k)) { // auto-boxing int -> Integer
                map.put(k, 1);
            } else {
                map.put(k, map.get(k) + 1); // update amount of the key
            }
        }

        for (Integer m : map.keySet()) {
            if (map.keySet().contains(m + 1)) {
                res += map.get(m);
            }    
        }
        return res;        
    }
}


// for (int k : arr) {
//     if (!map.keySet().contains(Integer.valueOf(k))) { // may actually auto-boxing, but for safety
//         map.put(Integer.valueOf(k), Integer.valueOf(1));
//     }
// }