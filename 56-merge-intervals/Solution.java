import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Map<Integer, Integer[]> pairs = new TreeMap<>();
        // for (int[] n : intervals) {
        //     pairs.put((Integer)n[0], new Integer[]{n[0], n[1]});
        // }
        // int len = pairs.size();
        // for (int i = 0; i < len - 1; i++) {
        //     if (pairs.get)
        // }
        int amount = intervals.length;
        List<Integer[]> copy = new ArrayList<>();
        for (int[] pair : intervals) {
            copy.add(new Integer[]{pair[0], pair[1]});
        }

        for (int k = 0; k <= amount - 2; k++) {
            if (copy.get(k)[1] >= copy.get(k+1)[0]) {
                copy.get(k)[1] = copy.get(k+1)[1];
                copy.remove(k+1);
                k--;
                amount--;
            }
        }

        int[][] res = new int[copy.size()][];
        for (int m = 0; m < copy.size(); m++) {
            res[m] = new int[]{copy.get(m)[0], copy.get(m)[1]};
        }
        return res;

    }
}